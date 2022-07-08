import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Canvas extends JPanel implements Runnable, KeyListener {

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

        // Chão
        g.setColor(Color.darkGray);
        g.fillRect(0, 480, 800, 100);

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

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_D){
            robo.setDirecao(1);

        } else if(e.getKeyCode() == KeyEvent.VK_A){
            robo.setDirecao(-1);
        } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
            robo.iniciaPulo();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_A){
            robo.setDirecao(0);
        }

    }
}
