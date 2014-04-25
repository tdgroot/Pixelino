package nl.tdegroot.games.Pixelino.physics;

public class BoundingBox {

    public Vector2i position, size;

    public BoundingBox(int x, int y, int width, int height) {
        position = new Vector2i(x, y);
        size = new Vector2i(width, height);
    }

    public static boolean collides(BoundingBox a, BoundingBox b) {
        if (abs(a.position.x - b.position.x) < a.size.x + b.size.x) {
            if (abs(a.position.y - b.position.y) < a.size.y + b.size.y) {
                return true;
            }
        }
        return false;
    }

    private static int abs(int i) {
        return i < 0 ? i * -1 : i;
    }

}
