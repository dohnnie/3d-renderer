import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Window {
    
    static double thetaX[] = new double[9];
    static double thetaY[] = new double[9];
    
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

        double heading = Math.toRadians(thetaX[0]);
            Matrix3 headingTransform = new Matrix3(new double[] {
                Math.cos(heading), 0,  -Math.sin(heading),
                0, 1, 0,
                Math.sin(heading), Math.cos(heading)
            });

        double pitch = Math.toRadians(thetaY[0]);
            Matrix3 pitchTransform = new Matrix3(new double[] {
                1, 0, 0,
                0, -Math.cos(pitch), Math.sin(pitch),
                0, Math.sin(pitch), Math.cos(pitch)
            });

        //Merge matrices in advance
        Matrix3 transform = headingTransform.multiply(pitchTransform);
        
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
                    Vertex v1 = transform.transform(t.v1);
                    Vertex v2 = transform.transform(t.v2);
                    Vertex v3 = transform.transform(t.v3);

                    Path2D path = new Path2D.Double();
                    path.moveTo(t.v1.x, t.v1.y);
                    path.lineTo(t.v2.x, t.v2.y);
                    path.lineTo(t.v3.x, t.v3.y);
                    path.closePath();
                    g2.draw(path);
                }
            }
        };

        renderPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                double yi = 180.0 / renderPanel.getHeight();
                double xi = 180.0 / renderPanel.getWidth();
                thetaX[0] = (int) (e.getX() * xi);
                thetaY[0] = -(int) (e.getY() * yi);
                renderPanel.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });

        pane.add(renderPanel, BorderLayout.CENTER);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}