package nl.tdegroot.games.Pixelino.graphics;

import nl.tdegroot.games.Pixelino.entity.Entity;
import nl.tdegroot.games.Pixelino.entity.Player;

public class Screen {

    private int width, height;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void clear() {
        clear(0);
    }

    public void clear(int color) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    public void render(Entity entity) {
        int xp = entity.getX();
        int yp = entity.getY();
        for (int yy = 0; yy < entity.getHeight(); yy++) {
            int ya = yy + yp;
            for (int xx = 0; xx < entity.getWidth(); xx++) {
                int xa = xx + xp;

                if (xa < -entity.getWidth() || xa >= width || ya >= height) break;

                if (xa < 0)
                    xa = 0;

                int col = entity.getSprite().pixels[xx + yy * entity.getWidth()];
                pixels[xa + ya * width] = col;

            }
        }
    }

    public void render(Player player) {
        int xp = player.getX();
        int yp = player.getY();
        for (int yy = 0; yy < player.getHeight(); yy++) {
            int ya = yy + yp;
            for (int xx = 0; xx < player.getWidth(); xx++) {
                int xa = xx + xp;

                if (xa < -player.getWidth() || xa >= width || ya >= height) break;

                if (xa < 0)
                    xa = 0;

                pixels[xa + ya * width] = 0xFF8300;
            }
        }
    }

    public void render(int x, int y, Sprite sprite) {
        for (int yy = 0; yy < sprite.getHeight(); yy++) {
            int ya = yy + y;
            for (int xx = 0; xx < sprite.getWidth(); xx++) {
                int xa = xx + x;
                if (xa < -sprite.getWidth() || xa >= width || ya >= height) break;

                if (xa < 0)
                    xa = 0;
                int col = sprite.pixels[xx + yy * sprite.getWidth()];
                int ignoreCol = 0xFFFF00FF;
                if (col == ignoreCol) continue;
                pixels[xa + ya * width] = col;
            }
        }
    }

    public void fillRect(int x, int y, int width, int height, int col) {
        for (int yy = 0; yy < height; yy++) {
            int ya = yy + y;
            for (int xx = 0; xx < width; xx++) {
                int xa = xx + x;
                pixels[xa + ya * this.width] = col;
            }
        }
    }

}
