import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sprite extends Tile {

    private int xPos;
    private int yPos;
    private int preX;
    private int preY;
    private String preImg;
    private String input;
    private boolean attack;

    public Sprite(int x, int y, String filename) {
        super(x, y, filename);
        xPos = x;
        yPos = y;
    }

    public void moveSprite(KeyEvent e) {

        if ('w' == e.getKeyChar()) {
            yPos--;
        } else if ('s' == e.getKeyChar()) {
            yPos++;
        } else if ('a' == e.getKeyChar()) {
            xPos--;
        } else if ('d' == e.getKeyChar()) {
            xPos++;
        } else if (32 == e.getExtendedKeyCode()) {
            attack = true;
            System.out.println("attack");
        } 

        setLocation(xPos, yPos);
        System.out.print(xPos + "   ");
        System.out.println(yPos);
    }
    
    public boolean isAttacking() {
        return attack;
    }

}
