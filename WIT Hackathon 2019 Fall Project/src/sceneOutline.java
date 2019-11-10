import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.media.Media;


public class sceneOutline {
    private static Image background;
    private static File dialogue;
    private static Image character;
    private static Media music;

    public sceneOutline(){
        //default constructor
    }

    public sceneOutline(String background, String dialogue, String character, String music) {
        setBackground(background);
        setDialogue(dialogue);
        setCharacter(character);
        setMusic(music);
    }

    public static void setBackground(String file) {
    	if(file.equals("none")) {
    		
    	}else {
    		FileInputStream imgIn;
    		try {
    			imgIn = new FileInputStream("Media\\Image\\Background\\" + file);
    			background = new Image(imgIn);
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
    	}
    }

    public static void setCharacter(String file) {
    	
    	if(file.equals("none")) {
    		
    	}else {
    		FileInputStream imgIn;
    		try {
    			imgIn = new FileInputStream("Media\\Image\\Character\\" + file);
    			character = new Image(imgIn);
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
    	}
    	
    }

    // setDialougue("python.txt")
    public static void setDialogue(String file) {
        dialogue = new File("Media\\Text\\" + file);
    }

    public void setMusic(String file){
        music = new Media(new File("Media\\Music\\" + file).toURI().toString());
    }

    public static Image getBackground() {
    	return background;
		
    }

    public static Image getCharacter() {
        return character;
    }

    public static File getDialogue() throws IOException{
        return dialogue;
    }

    public static Media getMusic(){
        return music;
    }

}
