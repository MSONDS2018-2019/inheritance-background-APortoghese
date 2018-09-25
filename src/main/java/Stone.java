import java.awt.image.BufferedImage;
/**
 * @author aportoghese20
 * creates and stores positions of stone tiles
 */
public class Stone extends Tile {
    
    //BufferedImage image;
    
    public Stone(int x, int y) {
        super(x, y, "file:images/stone.png");
    }
}
