import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Tile {
    
    //size of tiles
    public static final int WIDTH = 64, HEIGHT = 64;
    // location in pixles
    int x;
    int y;
    //image
    private BufferedImage image;
    //filename
    String filename;

    public Tile(int x, int y, String filename) {

        try {
            image = ImageIO.read(new URL(filename));
        } catch (IOException e) {
            System.out.println("Failed to load " + filename + " image.");
        }

        setLocation(x, y);
    }

    public void setLocation(int col, int row) {
        this.x = col;
        this.y = row;
    }

    /**
     * Gets the x-axis location of the tile.
     * @return the x-axis location
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the y-axis location of the tile.
     * @return the y-axis location
     */
    public int getY() {
        return this.y;
    }

    public BufferedImage getImage() {
        return this.image;
    }
    
    public void setImage(String file) {
        filename = file;
    }

    // draws the image
    public void draw(Graphics2D g2) {
        g2.drawImage(image, null, x * 64, y * 64);
    }

}
