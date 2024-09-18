import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

public class Point {
    int position[] = new int[3]; //(x, y, z)
    int pWidth = 5;
    int pHeight = 5;
    int length = 3;

    Point(int x, int y, int z) {
        this.position[0] = x;
        this.position[1] = y;
        this.position[2] = z;
    }

    Point addVectorToPoint(Vector v) {
        for(int i = 0; i < length; i++) {
            this.position[i] += v.direction[i];
        }

        return this;
    }

    Point subtractVectorFromPoint(Vector v) {
        for(int i = 0; i < length; i++) {
            this.position[i] -= v.direction[i];
        }

        return this;
    }

    Vector subtractPointFromPoint(Point p) {
        return new Vector(this.position[0] - p.position[0], 
            this.position[1] - p.position[1],
            this.position[2] - p.position[2]);
    }

    void drawPoint(Graphics g, JFrame frame) {
        g = frame.getGraphics();

        g.setColor(Color.black);
        g.fillOval(this.position[0], this.position[1], pWidth, pHeight);
    }
}