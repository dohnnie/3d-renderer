import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Graphics;

public class Window extends JFrame implements Runnable {

    Toolkit tk;
    Graphics g;
    Point p;

    int screenHeight;
    int screenWidth;

    Window(Point p) {
        super("3D Engine");
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        tk = Toolkit.getDefaultToolkit();
        this.p = p;
        g = getGraphics();

        screenHeight = tk.getScreenSize().height;
        screenWidth = tk.getScreenSize().width;


        setVisible(true);
    }
    public void run() {
        while(true) {
            p.drawPoint(g, this);
        }
    }

    public static void main(String[] args) {
        int windowWidth = 600;
        int windowHeight = 600;

        Point p1 = new Point(windowWidth / 2,windowHeight / 2,100);

        Thread window = new Thread(new Window(p1));
        window.start();
    }
}