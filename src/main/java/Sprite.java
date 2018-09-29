import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

//TODO make acctualy work
public class Sprite extends Tile {

    private int xPos;
    private int yPos;
    private int preX;
    private int preY;
    private String preImg;
    private String input;

    public Sprite(int x, int y) {
        super(x, y, "file:images/MainSprite/standing_sprite.png");
        xPos = x;
        yPos = y;
    }

    public void moveSprite(KeyEvent e) {
        preX = xPos;
        preY = yPos;
        preImg = super.filename;
        
        if ('w' == e.getKeyChar()) {
            yPos--;
        }
        else if ('s' == e.getKeyChar()) {
            yPos++;
        }
        else if ('a' == e.getKeyChar()) {
            xPos--;
        }
        else if ('d' == e.getKeyChar()) {
            xPos++;
        } else {
            yPos = yPos;
            xPos = xPos;
        }
        
        setLocation(xPos, yPos);
        System.out.print(xPos + "   ");
        System.out.println(yPos);
    }

    public int getPreviousX() {
        return preX;
    }
    public int getPreviousY() {
        return preY;
    }
}
