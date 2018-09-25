import java.awt.image.BufferedImage;

public class Grass extends Tile {
    
    BufferedImage image;
    
    public Grass(int x, int y) {
        super(x, y, "file:images/grass.png");
    }
}
