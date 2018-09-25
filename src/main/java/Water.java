import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Water extends Tile {

    BufferedImage image;

    public Water(int x, int y) {
        super(x, y, "file:images/water.png");

    }
}
