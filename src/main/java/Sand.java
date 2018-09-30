import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * @author aportoghese20
 * creates and stores positions of sand tiles
 */
public class Sand extends Tile {

    public Sand(int x, int y) {
        super(x, y, "file:images/sand.png");
    }

}
