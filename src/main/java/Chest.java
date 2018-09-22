import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Chest extends Tile {

    BufferedImage image;
    static int x, y;

    public Chest() {
        super(x, y, "file:images/chest_1.png");

        try {
            image = ImageIO.read(new URL("file:images/chest_1.png"));
        } catch (IOException e) {
            System.out.println("Failed to load file:images/chest_1.png");
        }

        setLocation(x, y);
    }

}
