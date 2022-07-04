import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Robo {

   private BufferedImage roboRun[];
   private int runAtual;
   private int timer;

    public Robo(){

        timer = 0;

        roboRun = new BufferedImage[8];
        runAtual = 0;

        try{
            for(int i = 0; i < 8; i++){
                String run = "sprites/Run (" + (i + 1) + ").png";
                roboRun[i] = ImageIO.read(new File(run));
                System.out.println("Imagens run " + run + " carregadas !");
            }
        }catch (Exception e){
            System.out.println("Imagens Run não carregadas ");
        }

    }
    public void atualizar(){

        timer++;
        if(timer >= 5){
            runAtual++;
            if(runAtual == 8){
                runAtual = 0;
            }
            timer = 0;
        }
    }

    public void pintar(Graphics2D g){
        g.drawImage(roboRun[runAtual], 100, 5, null);
    }
}
