import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sand extends Tile {
    
    private BufferedImage image;
    private int x;
    private int y;
    
    public Sand(int x, int y) {
        super(x, y, "file:images/sand.png");
        
        try {
            image = ImageIO.read(new URL("file:images/sand.png"));
        } catch (IOException e) {
            System.out.println("Failed to load file:images/sand.png");
        }
        
        x = getX();
        y = getY();

        super.setLocation(x, y);
    }

}
