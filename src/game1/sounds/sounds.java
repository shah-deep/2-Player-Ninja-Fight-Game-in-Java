package game1.sounds;

import java.io.*;
import javax.sound.sampled.*;
   
public class sounds {
	 
   public static Clip clip;
   
	 
   public sounds(String filePath) {
	  
      
      try {
    	  File soundFile = new File(filePath);
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         clip = AudioSystem.getClip();
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
   public void stop()
   {
	   clip.stop();
	   
   }
}
  