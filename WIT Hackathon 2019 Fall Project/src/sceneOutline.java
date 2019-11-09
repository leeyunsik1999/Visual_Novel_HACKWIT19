import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class sceneOutline {
    private File background;
    private File dialogue;
    private File character;
    private Media music;

    public sceneOutline(){
        //default constructor
    }

    public sceneOutline(String background, String dialogue, String character, String music) {
        setBackground(background);
        setDialogue(dialogue);
        setCharacter(character);
        setMusic(music);
    }

    public void setBackground(String file) {
        this.background = new File("\\Images\\Background\\" + file);
    }

    public void setCharacter(String file) {
        this.character = new File("\\Images\\Character\\" + file);
    }

    // setDialougue("python.txt")
    public void setDialogue(String file) {
        this.dialogue = new File("\\text\\" + file);
    }

    public void setMusic(String file){
        this.music = new Media("\\music\\" + file);
    }

    public BufferedImage getBackground() throws IOException{
        return ImageIO.read(this.background);
    }

    public BufferedImage getCharacter() throws IOException{
        return ImageIO.read(this.character);
    }

    public File getDialogue() throws IOException{
        return dialogue;
    }

    public MediaPlayer getMusic(){
        return new MediaPlayer(this.music);
    }

}
