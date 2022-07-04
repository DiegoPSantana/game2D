import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel implements Runnable {

    public Canvas(){
        Thread gameLoop = new Thread(this);
        gameLoop.start();
    }

    int x;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x, 50, 100, 100);
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
        x++;
    }

    private void dorme(){
        try{
            Thread.sleep(1000/60);
        } catch (Exception e){
            System.out.println("Error em Sleep " + e);
        }
    }

}
