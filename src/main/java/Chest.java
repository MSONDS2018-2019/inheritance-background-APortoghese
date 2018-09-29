import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * @author aportoghese20
 * creates and stores positions of the treasure chest tile
 */
// size of treasure chest on tile is 38x30 on a 64x64 background
public class Chest extends Tile {

    public Chest(int x, int y) {
        super(x, y, "file:images/chest_1.png");
        //TODO fix bug so chest can have tiles other than grass under it
    }
    
}
