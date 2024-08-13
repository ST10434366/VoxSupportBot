//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^{ BEGINNING OF FILE }^^^^^^^^^^^^^^^^^^^^^^^^^^//
package chatbot;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
/**
 *  
 * @author: ST10434366
 *  
 */
public class TextToSpeechClass {
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
    // Default constructor does not perform any initialisation or setup tasks.
    public TextToSpeechClass()
    {
    }
    
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//
    // Converts the given text to speech using the FreeTTS library.
    // - Configures the system properties to include specific voice directories.
    // - The text is then spoken using the configured voice.
    // - Finally, the voice is deallocated upon completed execution.
    public void textToSpeech(String text)
    {
    System.setProperty("freetts.voices",
            "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory," +
            "com.sun.speech.freetts.en.us.cmu_time_awb.AlanVoiceDirectory");

    VoiceManager voiceManager = VoiceManager.getInstance();
    Voice voice = voiceManager.getVoice("kevin16");

        if (voice != null) {
            voice.allocate();

            // Set parameters to approximate Twitch stream TTS
            voice.setRate(120);  // Moderate to fast speech rate
            voice.setPitch(100); // Neutral pitch
            voice.setVolume(2);  // Medium volume

            voice.speak(text);
            voice.deallocate();
        } 
        else 
        {
            System.err.println("Voice not found.");
        }
    }
}
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^{ END OF FILE }^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^//

