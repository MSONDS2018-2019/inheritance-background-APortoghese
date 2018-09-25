import java.awt.image.BufferedImage;

public class Stone extends Tile {
    
    BufferedImage image;
    private int x;
    private int y;
    
    public Stone(int x, int y) {
        super(x, y, "file:images/stone.png");
    }
}
