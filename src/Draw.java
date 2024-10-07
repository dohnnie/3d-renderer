import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Draw extends JFrame implements Runnable{
    
    Graphics g;
    Window window;
    int width;
    int height;

    Draw(Graphics g, Window window, int width, int height) {
        this.window = window;
        this.g = g;
        this.width = width;
        this.height = height;

        
    }

    void drawPoint(Point p) {
        g.setColor(Color.black);
        g.fillRect(p.x, p.y, p.pWidth, p.pHeight);

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    void resetImage() {
        g.setColor(Color.white);
        g.fillRect(0,0, width, height);

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void run() {
        
    }
}
