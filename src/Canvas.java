import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel implements Runnable {

    public Canvas(){
        Thread gameLoop = new Thread(this);
        gameLoop.start();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Background
        g.setColor(Color.white);
        g.fillRect(0, 0, 800, 600);
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
    }

    private void dorme(){
        try{
            Thread.sleep(1000/60);
        } catch (Exception e){
            System.out.println("Error em Sleep " + e);
        }
    }

}
