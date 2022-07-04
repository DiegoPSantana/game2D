import javax.swing.*;

public class Janela {
    public static void main(String [] args){
        JFrame janela = new JFrame("Game 2D");
        janela.setSize(800, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);

        janela.setVisible(true);

        Canvas canvas = new Canvas();
        janela.add(canvas);

    }
}
