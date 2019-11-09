import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class sceneOutline {
    private String background;
    private String dialogue;
    private String character;
    private String music;

    public sceneOutline(){
    }

    public void setBackground(String file){
       this.background = "\\Images\\Background\\"+file;
    }

    public void setCharacter(String file){
        this.background = "\\Images\\Character\\"+file;
    }

    //setDialougue("python.txt")
    public void setDialogue(String file){
        this.dialogue = "\\text\\"+file;
    }

    public BufferedImage getBackground(){
        return ImageIO.read(new File(this.background));
    }

    public File getCharacter(){
        return new File(this.background);
    }


}
