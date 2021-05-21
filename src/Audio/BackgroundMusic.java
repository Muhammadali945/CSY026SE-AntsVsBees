package Audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * @author Muhammad
 * Some piece of code has been copied from stackoverflow website.
 * This function reads music files from the specified directory and its constructor expects 
 * the filename of the music.
 */

public class BackgroundMusic {


    private Clip clip;

    public BackgroundMusic(String filename) {
        //assign audio input stream
        try{
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(filename));
            AudioFormat baseFormat = audioIn.getFormat();
            AudioFormat decodeFormat = new AudioFormat (
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            //get the input stream
            AudioInputStream clipAudioIn =
                    AudioSystem.getAudioInputStream(
                            decodeFormat,audioIn);
            clip = AudioSystem.getClip();
            clip.open(clipAudioIn);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
// function for playing the saved audio stream; button has been added for pause/play
    public void play() {
        if (clip ==null) return;
        stop();
        clip.setFramePosition(0);
        clip.start();
    }

    //to stop music ; button has been added in the game for this function
    public void stop() {
        if (clip.isRunning()) {
            clip.stop();
        }
    }

}


