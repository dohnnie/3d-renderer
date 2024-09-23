public class Vector {
    int x;
    int y;
    int z;

    Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //Vector addition
    Vector addVectorToVector(Vector u) {
        this.x += u.x;
        this.y += u.y;
        this.z += u.z;

        return this;
    }

    //Vector subtraction
    Vector subtractVectorFromVector(Vector u) {
        this.x -= u.x;
        this.y -= u.y;
        this.z -= u.z;

        return this;
    }

    //Multiplying a 1x3 vector by { {cos(theta), -sin(theta), 0}, {sin(theta), cos(theta), 0}, {0, 0, 1}}
    Vector rotateXYPlane(int angle) {
        Vector result = new Vector();
        double angleRad = Math.toRadians(angle);
        result.x = (int)(Math.cos(angleRad) * this.x + -Math.sin(angleRad) * this.y);
        result.y = (int)(Math.sin(angleRad) * this.x + Math.cos(angleRad) * this.y);
        result.z= 1 * this.z;

        return result;
    }

    //Multiplying a 1x3 vector by { {cos(theta), 0, -sin(theta)}, {0, 1, 0}, {-sin(theta), 0, cos(theta)}}
    Vector rotateXZPlane(int angle) {
        Vector result = new Vector();
        double angleRad = Math.toRadians(angle);
        result.x = (int)(Math.cos(angleRad) * x + -Math.sin(angleRad) * this.z);
        result.y = 1 * this.y;
        result.z = (int)(-Math.sin(angleRad) * x + Math.cos(angleRad) * this.z);

        return result;
    }

    //Multiplying a 1x3 vector by { {1, 0, 0}, {0, cos(theta), -sin(theta)}, {0, sin(theta), cos(theta)}}
    Vector rotateYZPlane(int angle) {
        Vector result = new Vector();
        double angleRad = Math.toRadians(angle);

        result.x = 1 * this.x;
        result.y = (int)(Math.cos(angleRad) * this.y + -Math.sin(angleRad) * this.z);
        result.z = (int)(Math.sin(angleRad) * this.y + Math.cos(angleRad) * this.z);

        return result;
    }

    Vector scaleBy(int x, int y, int z) {
        Vector result = new Vector();
        result.x = this.x * x;
        result.y = this.y * y;
        result.y = this.z * z;

        return result;
    }
}