import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Chest extends Tile {

    BufferedImage image;

    public Chest(int x, int y) {
        super(x, y, "file:images/chest_1.png");
        //TODO fix bug so chest can have tiles other than grass under it
    }

}
