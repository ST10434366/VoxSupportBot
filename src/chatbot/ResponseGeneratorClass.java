//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^{ BEGINNING OF FILE }^^^^^^^^^^^^^^^^^^^^^^^^^^//
package chatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *  
 * @author: ST10434366
 *  
 */
public class ResponseGeneratorClass {
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
    // Default constructor does not perform any initialisation or setup tasks.
    public ResponseGeneratorClass()
    {
    }
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
    // Generates a response by executing a Python script.
    // - Uses a ProcessBuilder to run the Python script 'bot.py' with the given prompt.
    // - Captures the output of the Python script through an InputStreamReader.
    // - Appends each line of the script's output to a StringBuilder and returns the result.
    // - If an IOException or InterruptedException occurs, returns a default error message.
    public String generateResponse(String prompt)
    {
        try
        {
            ProcessBuilder pb = new ProcessBuilder("python", "src\\chatbot\\bot.py", prompt);
            Process process = pb.start();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null)
            {
            result.append(line);
            }
            process.waitFor();

            return result.toString();
            
        } 
        catch (IOException | InterruptedException e)
        {
            return "Unable to understand request!";
        }
    } 
}
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^{ END OF FILE }^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
