import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 * Area class.
 * @author jddevaughnbrown
 *
 */
@SuppressWarnings("serial")
public class Area extends JPanel implements KeyListener {

    /**
     * Calculates the number of tiles based on the Window's width.
     */
    protected static final int NUM_TILES_X = Window.WIDTH / 64;
    /**
     * Calculates the number of tiles based on the Window's height.
     */
    protected static final int NUM_TILES_Y = Window.HEIGHT / 64;
    /**
     * The maximum x position to place a tree on the screen.
     */
    protected static final double MAX_TREE_X = Window.WIDTH - Tree.WIDTH;
    /**
     * The maximum y position to place a tree on the screen.
     */
    protected static final double MAX_TREE_Y = Window.HEIGHT - Tree.HEIGHT;

    protected char inputKey = ' ';

    /**
     * The trees that are scattered around the area.
     */
    protected Tree[] trees;

    /**
     * array of tiles (map).
     */
    protected Tile[][] tiles;
    
    protected Sprite[][] spritePosition;

    protected Sprite sprite;

    /**
     * To hide this parameter from being passed around.
     */
    private Graphics2D g2;

    /**
     * The constructor for the Area class.
     */
    public Area() {
        g2 = null;

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
    }

    /**
     * Draws the specified tree.
     * @param i
     *      - the array position of the tree to be drawn
     */
    protected void drawTree(int i) {
        if (trees != null) {
            trees[i].draw(g2);
        }
    }

    /**
     * draws added tiles.
     * @param i
     *      - x coordinate of tile on screen
     * @param j
     *      - y coordinate of tile on screen
     */
    public void drawTile(int i, int j) {

        if (tiles[i][j] != null) {
            tiles[i][j].draw(g2);
        }
    }
    
    public void drawSprite(int i, int j) {

        if (spritePosition[i][j] != null) {
            spritePosition[i][j].draw(g2);
        }
    }

    // Overridden function from JPanel, which allows us to
    // write our own paint method which draws our area.
    @Override
    public void paint(Graphics g) {
        // This calls JPanel's paintComponent method to handle
        // the lower-level details of drawing in a window.
        super.paint(g);

        g2 = (Graphics2D) g;

        drawTiles();
        drawTrees();
        drawSprites();

        // Sync for cross-platform smooth rendering.
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Draws the tiles to the screen.
     */
    protected void drawTiles() {
        // Implement in a child class.
    }
    
    protected void drawSprites() {
        
    }

    /**
     * Draws the trees to the screen.
     */
    protected void drawTrees() {
        // Implement in a child class.
    }

    /**
     * Key Event methods
     * @param e
     * @return 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        sprite.moveSprite(e);
        drawSprite(sprite.getX(), sprite.getY());
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}
