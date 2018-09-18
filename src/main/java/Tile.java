import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Tile {
	//size of tile
	public static final int WIDTH = 64, HEIGHT = 64;
	//location in pixles
	private int x, y;
	//image
	BufferedImage image;

	public Tile(int x, int y, String filename) {
		
		try {
            this.image = ImageIO.read(new URL(filename));
        } catch (IOException e) {
            System.out.println("Failed to load " + filename + " image.");
        }
		
		setLocation(x, y); 
	}
	
	
	  public void setLocation(int xPos, int yPos) {
	        this.x = xPos;
	        this.y = yPos;
	    }

	    /**
	     * Gets the x-axis location of the tile.
	     * @return the x-axis location
	     */
	    public int getX() {
	        return this.x;
	    }

	    /**
	     *  Get the y-axis location of the tile.
	     * @return the y-axis location
	     */
	    public int getY() {
	        return this.y;
	    }
	    
	//draws the image
	public void draw(Graphics2D g2) {
        g2.drawImage(this.image, null, this.x, this.y);
    }
}
