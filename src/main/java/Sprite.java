import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

//curently not working
public class Sprite extends Tile {

    BufferedImage standing;

    private int mX, mY;
    private int X, Y;
    private String filename;
    private KeyEvent input;
    private Graphics2D D2;

    public Sprite(int x, int y, String filename) {
        super(x, y, filename);
        // moving x and y postions of the sprite
        mX = x;
        mY = y;
        this.filename = filename;
        X = super.getX();
        Y = super.getY();
        D2 = null;

        loadImages();

    }

    private void loadImages() {

        try {
            standing = ImageIO.read(new URL(this.filename));
        } catch (IOException e) {
            System.out.println("Failed to load " + filename + " image.");
        }
    }

    /*
     * public void drawSprite(Graphics2D g2) { g2.drawImage(standing, null, X, Y); }
     */

    public void moveing() {
        // keyPressed(input);
        X += mX;
        Y += mY;
        setLocation(X, Y);
    }

    public void keyPressed(KeyEvent e) {

        int key = (int) e.getKeyCode();

        while (key == 0) {
            if (key == KeyEvent.VK_LEFT) {
                mX = -2;
            }

            if (key == KeyEvent.VK_RIGHT) {
                mX = 2;
            }

            if (key == KeyEvent.VK_UP) {
                mY = -2;
            }

            if (key == KeyEvent.VK_DOWN) {
                mY = 2;
            }

            key = e.getKeyCode();
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            mX = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            mX = 0;
        }

        if (key == KeyEvent.VK_UP) {
            mY = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            mY = 0;
        }
    }

}
