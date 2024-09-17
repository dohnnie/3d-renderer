import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.geom.Path2D;

public class Window {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setLayout(new BorderLayout());

        //Creating 4 triangle objects
        List<Triangle> tris = new ArrayList<>();
        //Face 1
        tris.add(new Triangle(new Vertex(100, 100, 100),
                                new Vertex(-100, -100, 100),
                                new Vertex(-100, 100, -100),
                                Color.white));
        //Face 2
        tris.add(new Triangle(new Vertex(100, 100, 100),
                                new Vertex(-100, -100, 100),
                                new Vertex(100, -100, -100),
                                Color.RED));
        //Face 3
        tris.add(new Triangle(new Vertex(-100, 100, -100),
                                new Vertex(100, -100, -100),
                                new Vertex(100, 100, 100),
                                Color.GREEN));
        //Face 4
        tris.add(new Triangle(new Vertex(-100, 100, -100),
                                new Vertex(100, -100, -100),
                                new Vertex(-100, -100, 100),
                                Color.BLUE));

        //Create a render panel
        JPanel renderPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.black);
                g2.fillRect(0, 0, getWidth(), getHeight());

                //Rendering happens here
                //The generated shape is centered on the origin (0, 0, 0), and we will do a rotation around the origin later
                g2.translate(getWidth() / 2, getHeight() / 2);
                g2.setColor(Color.WHITE);
                for(Triangle t : tris) {
                    Path2D path = new Path2D.Double();
                    path.moveTo(t.v1.x, t.v1.y);
                    path.lineTo(t.v2.x, t.v2.y);
                    path.lineTo(t.v3.x, t.v3.y);
                    path.closePath();
                    g2.draw(path);
                }
            }
        };

        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}