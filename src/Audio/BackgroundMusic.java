package Audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BackgroundMusic {


    private Clip clip;

    public BackgroundMusic(String s) {
        //assign audio input stream
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(s));
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat (
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais =
                    AudioSystem.getAudioInputStream(
                            decodeFormat,ais);
            clip = AudioSystem.getClip();
            clip.open(dais);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip ==null) return;
        stop();
        clip.setFramePosition(0);
        clip.start();
    }

    //to stop music ; button has to be added in the game for this function
    public void stop() {
        if (clip.isRunning()) {
            clip.stop();
        }
    }

}


