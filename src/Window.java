import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class Window extends JFrame implements Runnable {

    Toolkit tk;
    Graphics g;
    Point[] p;
    Draw draw;

    int screenHeight;
    int screenWidth;

    Window(Point[] p) {
        super("3D Engine");
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

        this.tk = Toolkit.getDefaultToolkit();
        this.p = p;
        this.g = getGraphics();

        //Thread draw = new Thread(new Draw(this.g, this, getWidth(), getHeight()));
        //draw.start();
        draw = new Draw(this.g, this, getWidth(), getHeight());


        screenHeight = tk.getScreenSize().height;
        screenWidth = tk.getScreenSize().width;
        
        addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {

           }

           @Override
           public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    //Stops the program
                    case KeyEvent.VK_ESCAPE -> System.exit(0);
                    //Redraw the screen
                    case KeyEvent.VK_D -> {
                        draw.resetImage();
                        System.out.println("D pressed!");
                    }
                    //Scale the location of all points by .5
                    case KeyEvent.VK_A -> {

                    }
                    //Scale the location of all points by 2
                    case KeyEvent.VK_S -> {

                    }
                    //Rotate all the points by 15 degrees on the XY plane
                    case KeyEvent.VK_R -> {

                    }
                }
           }
           
           @Override
           public void keyReleased(KeyEvent e) {

           }
        });

    }
    public void run() {
        while(true) {
            for(int i = 0; i < 100; i++) {
                draw.drawPoint(p[i]);
            }
            System.out.println("Done!");
        }
    }

    public static void main(String[] args) {
        int windowWidth = 600;
        int windowHeight = 600;
        int targetDepth = 100;
        Random rand = new Random(System.nanoTime());

        
        Point[] points = new Point[100];
        for(int i = 0; i < 100; i++) {
            int randWidth = rand.nextInt(windowWidth + 1);
            int randHeight = rand.nextInt(windowHeight + 1);
            int randDepth = rand.nextInt(targetDepth + 1);
            points[i] = new Point(randWidth, randHeight, randDepth);
        }

        Thread window = new Thread(new Window(points));
        window.start();
    }
}