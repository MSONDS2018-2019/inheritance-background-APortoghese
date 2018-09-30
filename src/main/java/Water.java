import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * @author aportoghese20
 * creates and stores positions of water tiles
 */
public class Water extends Tile {

    public Water(int x, int y) {
        super(x, y, "file:images/water.png");

    }
}
