import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel implements Runnable {

    private Robo robo;

    public Canvas(){

        robo = new Robo();

        Thread gameLoop = new Thread(this);
        gameLoop.start();

    }


    @Override
    public void paintComponent(Graphics g2){
        super.paintComponent(g2);

        Graphics g = (Graphics2D) g2.create();

        // Background
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);

        // Pintando o robo run
        robo.pintar((Graphics2D) g);
    }

    @Override
    public void run() {
        while(true){
            update();
            repaint();
            dorme();
        }
    }

    private void update() {
        robo.atualizar();
    }

    private void dorme(){
        try{
            Thread.sleep(1000/60);
        } catch (Exception e){
            System.out.println("Error em Sleep " + e);
        }
    }

}
