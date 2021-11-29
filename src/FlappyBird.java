import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;

public class FlappyBird {

    public static FlappyBird flappyBird;
    public final int Width = 800, Height = 800;
    public Renderer renderer;

    // test

    public FlappyBird () {
        JFrame jframe = new JFrame();
        //Timer timer = new Timer(20, this);

        renderer = new Renderer();

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(Width, Height);
        jframe.setResizable(false);
        jframe.setVisible(true);


    }
    public void repaint(Graphics g) {
    }
    public static void main(String []args){

        flappyBird = new FlappyBird();

    }

}
