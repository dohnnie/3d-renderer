public class Vector {
    int direction[] = new int[3]; //(x, y, z)
    int length = 3;

    Vector() {
        for(int i = 0; i < length; i++) {
            this.direction[i] = 0;
        }
    }

    Vector(int x, int y, int z) {
        this.direction[0] = x;
        this.direction[1] = y;
        this.direction[2] = z;
    }

    Vector addVectorToVector(Vector u) {
        for(int i = 0; i < length; i++) {
            this.direction[i] += u.direction[i];
        }

        return this;
    }

    Vector subtractVectorFromVector(Vector u) {
        for(int i = 0; i < length; i++) {
            this.direction[i] -= u.direction[i];
        }

        return this;
    }

    Vector rotateXYPlane(int angle) {
        Vector result = new Vector();
        double angleRad = Math.toRadians(angle);
        result.direction[0] = (int)(Math.cos(angleRad) * this.direction[0] + -Math.sin(angleRad) * this.direction[1]);
        result.direction[1] = (int)(Math.sin(angleRad) * this.direction[0] + Math.cos(angleRad) * this.direction[1]);
        result.direction[2] = 1 * this.direction[2];

        return result;
    }

    Vector rotateXZPlane(int angle) {
        Vector result = new Vector();
        double angleRad = Math.toRadians(angle);
        result.direction[0] = (int)(Math.cos(angleRad) * this.direction[0] + -Math.sin(angleRad) * this.direction[2]);
        result.direction[1] = 1 * this.direction[1];
        result.direction[2] = (int)(-Math.sin(angleRad) * this.direction[0] + Math.cos(angleRad) * this.direction[2]);

        return result;
    }

    Vector rotateYZPlane(int angle) {
        Vector result = new Vector();
        double angleRad = Math.toRadians(angle);

        result.direction[0] = 1 * this.direction[0];
        result.direction[1] = (int)(Math.cos(angleRad) * this.direction[1] + -Math.sin(angleRad) * this.direction[2]);
        result.direction[2] = (int)(Math.sin(angleRad) * this.direction[1] + Math.cos(angleRad) * this.direction[2]);

        return result;
    }

    Vector scaleBy(int x, int y, int z) {
        Vector result = new Vector();
        result.direction[0] = this.direction[0] * x;
        result.direction[1] = this.direction[1] * y;
        result.direction[2] = this.direction[2] * z;

        return result;
    }
}