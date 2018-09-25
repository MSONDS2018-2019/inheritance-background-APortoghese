import java.awt.image.BufferedImage;

public class Grass extends Tile {
    
    BufferedImage image;
    private int x;
    private int y;
    
    public Grass(int x, int y) {
        super(x, y, "file:images/grass.png");
    }
}
