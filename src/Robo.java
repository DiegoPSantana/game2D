import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Robo {

   private BufferedImage roboRun[];
   private int runAtual;
   private int timer;

   // Tamanho do Robo
   private int largura, altura;

   // Posição do Robo
    private int posX, posY;

    public Robo(){
        largura = 200;
        altura = 200;

        posX = 300;
        posY = 300;

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
        g.drawImage(roboRun[runAtual], posX, posY, posX + largura, posY + altura, 0, 0,
                roboRun[runAtual].getWidth(), roboRun[runAtual].getHeight(),
                null);
    }
}
