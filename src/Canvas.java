import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 100, 100);
    }
}
