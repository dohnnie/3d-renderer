public class Vector {
    int direction[] = new int[3]; //(x, y, z)
    int length = 3;

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
}