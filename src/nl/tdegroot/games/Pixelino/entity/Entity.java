package nl.tdegroot.games.Pixelino.entity;

import nl.tdegroot.games.Pixelino.graphics.Screen;
import nl.tdegroot.games.Pixelino.graphics.Sprite;
import nl.tdegroot.games.Pixelino.physics.BoundingBox;
import nl.tdegroot.games.Pixelino.physics.Collidable;

import java.util.List;

public abstract class Entity implements Collidable {

    protected int x, y;
    protected int width, height;

    protected BoundingBox boundingBox;

    protected Sprite sprite;

    private boolean remove = false;

    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        boundingBox = new BoundingBox(x + width / 2, y + height / 2, width / 2, height / 2);
    }

    public abstract void tick(List<Collidable> entities);

    public abstract void render(Screen screen);

    public void remove() {
        remove = true;
    }

    public boolean shouldRemove() {
        return remove;
    }

    public boolean collidesWith(BoundingBox boundingBox) {
        return BoundingBox.collides(this.boundingBox, boundingBox);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

}
