
public class Point {
    int x, y, z; //(x, y, z)
    int pWidth = 5;
    int pHeight = 5;

    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point addVectorToPoint(Vector v) {
        return new Point(this.x += v.x, 
                        this.y += v.y, 
                        this.z += v.z);
    }

    Point subtractVectorFromPoint(Vector v) {
        return new Point(this.x -= v.x, 
                        this.y -= v.y, 
                        this.z -= v.z);
    }

    Vector subtractPointFromPoint(Point p) {
        return new Vector(this.x - p.x, 
            this.y - p.y,
            this.z - p.z);
    }

    void setPointToPoint(Point p) {
        this.x = p.x;
        this.y = p.y;
        this.z = p.z;
    }
}