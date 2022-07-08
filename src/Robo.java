import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;

public class Robo {

   private BufferedImage roboJump[];
   private int jumpAtual;
   private boolean pulando;

   private BufferedImage roboRun[];
   private int runAtual;

   private BufferedImage roboIdle[];
   private int idleAtual;
   private int timer;

   // Tamanho do Robo
   private int largura, altura;

   // Posição do Robo
    private int posX, posY;

    // Direção 0 Parado, 1 Direita, -1 Esquerda
    private int direcao, ultimaDirecao;
    private int velocidade;

    public Robo(){
        largura = 200;
        altura = 200;

        posX = 300;
        posY = 300;
        velocidade = 3;

        timer = 0;

        ultimaDirecao = 1;

        roboRun = new BufferedImage[8];
        runAtual = 0;

        roboIdle = new BufferedImage[10];
        idleAtual = 0;

        roboJump = new BufferedImage[10];
        jumpAtual = 0;
        pulando = false;

        try{
            for(int i = 0; i < 8; i++){
                String run = "sprites/Run (" + (i + 1) + ").png";
                roboRun[i] = ImageIO.read(new File(run));
                System.out.println("Imagens run " + run + " carregadas !");
            }

            // Robo movimento idle
            for(int i = 0; i < 10; i++){
                String idle = "sprites/Idle ("+(i + 1)+").png";
                roboIdle[i] = ImageIO.read(new File(idle));
                System.out.println("Imagens idle "+ idle + " carregadas !");
            }

            //Robo movimento Jump
            for(int i = 0; i < 10; i++){
                String jump = "sprites/Jump (" + (i + 1) + ").png";
                roboJump[i] = ImageIO.read(new File(jump));
                System.out.println("Imagens Jump "+ jump + " carregadas !");
            }
        }catch (Exception e){
            System.out.println(" Error ao carregar imagens " + e);
        }

    }
    public void atualizar(){

        // Mudanças das sprites
        timer++;
        if(pulando){
            if(timer >= 4){
                jumpAtual++;
               if(jumpAtual == 10){
                   jumpAtual = 0;
                   pulando = false;
                }
               timer = 0;
            } if(jumpAtual < 5){
                posY -=5;
            } else {
                posY +=5;
            }

        } else{
            if(timer >= 4){
                runAtual++;
                idleAtual++;
                // Run atual e idle atual ao chegar nas suas sprites finais irá começar do zero
                if(runAtual == 8 || idleAtual == 10){
                    runAtual = 0;
                    idleAtual = 0;
                }
                timer = 0;
            }
        }

        // Se direção for 0, 1 ou -1
        if(direcao == 1){
            posX += velocidade;
        } else if(direcao == -1){
            posX -= velocidade;
        }


    }

    public void pintar(Graphics2D g){
        // Para direita
        if(ultimaDirecao == 1){
            if(pulando){
                g.drawImage(roboJump[jumpAtual], posX, posY, posX + largura, posY + altura,
                        0, 0, roboJump[jumpAtual].getWidth(), roboJump[jumpAtual].getHeight(),
                        null);
            } else{
                if(direcao == 1){
                    g.drawImage(roboRun[runAtual], posX, posY, posX + largura, posY + altura,
                            0, 0, roboRun[runAtual].getWidth(), roboRun[runAtual].getHeight(),
                            null);
                } else{
                    g.drawImage(roboIdle[idleAtual], posX, posY, posX + largura, posY + altura,
                            0, 0, roboIdle[idleAtual].getWidth(),
                            roboIdle[idleAtual].getHeight(), null);
                }
            }
        }

        // Para esquerda
        if(ultimaDirecao == -1){
            if(pulando){
                g.drawImage(roboJump[jumpAtual], posX, posY, posX + largura, posY + altura,
                        roboJump[jumpAtual].getWidth(),0, 0, roboJump[jumpAtual].getHeight(),
                        null);
            } else{
                if(direcao == -1){
                    g.drawImage(roboRun[runAtual], posX, posY, posX + largura, posY + altura,
                            roboRun[runAtual].getWidth(), 0, 0, roboRun[runAtual].getHeight(),
                            null);
                } else{
                    g.drawImage(roboIdle[idleAtual], posX, posY, posX + largura, posY + altura,
                            roboIdle[idleAtual].getWidth(), 0, 0,
                            roboIdle[idleAtual].getHeight(), null);
                }
            }
        }

    }

    public void setDirecao(int dir){
        // Se direcão for diferente de zero 1 ou  -1, ultimaDirecão e direcao recebe a sua posição
        if(dir != 0){
            this.ultimaDirecao = dir;
            this.direcao = dir;
        } else{
            // Atualiza sua ultima direção
            this.direcao = dir;
        }
    }

    public void iniciaPulo(){
        if(pulando == false){
            pulando = true;
            timer = 0;
        }
    }
}
