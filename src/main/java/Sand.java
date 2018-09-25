import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sand extends Tile {
    
    private BufferedImage image;
    
    public Sand(int x, int y) {
        super(x, y, "file:images/sand.png");
    }

}
