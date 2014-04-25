package nl.tdegroot.games.Pixelino;

import nl.tdegroot.games.Pixelino.entity.Blockerino;
import nl.tdegroot.games.Pixelino.entity.Entity;
import nl.tdegroot.games.Pixelino.entity.Player;
import nl.tdegroot.games.Pixelino.graphics.Screen;
import nl.tdegroot.games.Pixelino.graphics.Sprite;
import nl.tdegroot.games.Pixelino.input.Keyboard;
import nl.tdegroot.games.Pixelino.input.Mouse;
import nl.tdegroot.games.Pixelino.physics.Collidable;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.*;
import java.util.List;

public class PixelGame extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static int width = 300;
    public static int height = 168;
    private static int scale = 3;
    private static Dimension size;
    private boolean running = false;

    private Thread thread;
    private Screen screen;

    private BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();

    private List<Collidable> entities = new ArrayList<Collidable>();

    private Sprite sprite;
    private Player player;
    private Blockerino blockerino;


    public PixelGame() {
        size = new Dimension(width * scale, height * scale);
        screen = new Screen(width, height);
        sprite = new Sprite("res/test.png");
        player = new Player(25, 25, 64, 64);
        blockerino = new Blockerino(100, 100, 48, 48);
        entities.add(blockerino);
        entities.add(player);
        init();
    }

    public void init() {
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        addMouseListener(new Mouse());
        addMouseMotionListener(new Mouse());
        addKeyListener(new Keyboard());
    }

    public static int getWindowWidth() {
        return width * scale;
    }

    public static int getWindowHeight() {
        return height * scale;
    }

    public synchronized void start() {
        thread = new Thread(this, "Game");
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        running = false;
        System.exit(0);
    }

    public void run() {
        long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 60;
        int frames = 0;
        int ticks = 0;
        long lastTimer1 = System.currentTimeMillis();
        requestFocus();
        while (running) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            while (unprocessed >= 1) {
                ticks++;
                tick();
                unprocessed -= 1;
            }

            render();
            frames++;

            if (System.currentTimeMillis() - lastTimer1 > 1000) {
                lastTimer1 += 1000;
                System.out.println(ticks + " ticks, " + frames + " fps");
                frames = 0;
                ticks = 0;
            }
        }
    }

    public void tick() {
        player.tick(entities);
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        player.render(screen);
        for (int i = 0; i < entities.size(); i++) {
            Entity e = (Entity) entities.get(i);
            e.render(screen);   
        }

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();

        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.WHITE);

        g.dispose();
        bs.show();
    }
}
