import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Chest extends Tile {

    BufferedImage image;
    private int x;
    private int y;

    public Chest(int x, int y) {
        super(x, y, "file:images/chest_1.png");

        try {
            image = ImageIO.read(new URL("file:images/chest_1.png"));
        } catch (IOException e) {
            System.out.println("Failed to load file:images/chest_1.png");
        }
        x = getX();
        y = getY();
        
        setLocation(x, y);
    }

}
