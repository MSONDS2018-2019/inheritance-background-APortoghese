import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Water extends Tile {

    BufferedImage image;
    private int x;
    private int y;

    public Water(int x, int y) {
        super(x, y, "file:images/water.png");

        try {
            image = ImageIO.read(new URL("file:images/water.png"));
        } catch (IOException e) {
            System.out.println("Failed to load file:images/water.png");
        }
        
        x = getX();
        y = getY();

        super.setLocation(x, y);
    }
}
