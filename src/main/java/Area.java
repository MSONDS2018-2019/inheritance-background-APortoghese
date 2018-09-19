import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
/**
 * Area class.
 * @author jddevaughnbrown
 *
 *
 *to add new tiles create and int constant, a tile object for it (in Area) and in OurArea specify where you want the tile
 */
@SuppressWarnings("serial")
public class Area extends JPanel {

    /**
     * Constants for the grass and stone tiles. added water, sand, and chest tiles
     */
    protected static final int GRASS = 0, STONE = 1, WATER = 2, SAND = 3, CCHEST = 4;
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
    
    

    /**
     * The trees that are scattered around the area.
     */
    protected Tree[] trees;
    
    /**
     * The area tile map.
     */
    protected int[][] tiles;

    /**
     * The grass and stone images used as the floor texture.
     */
    private BufferedImage grassImage, stoneImage;

    /**
     * To hide this parameter from being passed around.
     */
    private Graphics2D g2;
    
    // tile test
    protected Tile water;
    protected Tile sand;
    protected Tile closedChest;

    /**
     * The constructor for the Area class.
     */
    public Area() {
        // Load the grass image from the file.
        try {
            grassImage = ImageIO.read(new URL("file:images/grass.png"));
        } catch (IOException e) {
            System.out.println("Failed to load 'grass.png' image.");
        }

        // Load the stone image from the file.
        try {
            stoneImage = ImageIO.read(new URL("file:images/stone.png"));
        } catch (IOException e) {
            System.out.println("Failed to load 'stone.png' image.");
        }
        
        //initaizalize water
        water = new Tile(0, 0, "file:images/water.png"); 
        //initialize sand
        sand = new Tile(0, 0, "file:images/sand.png");
        //initailize closed chest
        closedChest = new Tile(0, 0, "file:images/chest_1.png");

        g2 = null;

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Window.WIDTH, Window.HEIGHT));
    }

    /**
     * Draws the grass at the specified tile.
     * @param i - the row number of the tile
     * @param j - the column number of the tile
     */
    protected void drawGrass(int i, int j) {
        g2.drawImage(grassImage, null, i * 64, j * 64);
    }

    /**
     * Draws the stone at the specified tile.
     * @param i - the row number of the tile
     * @param j - the column number of the tile position
     */
    protected void drawStone(int i, int j) {
        g2.drawImage(stoneImage, null, i * 64, j * 64);
    }

    /**
     * Draws the specified tree.
     * @param i - the array position of the tree to be drawn
     */
    protected void drawTree(int i) {
        if (trees != null) {
            trees[i].draw(g2);
        }
    }
    
    protected void drawWater(int i, int j) {
    	
    		g2.drawImage(water.getImage(), null, i * 64, j * 64);
    }
    
    protected void drawTile(int i, int j, Object obj) { 
    	
		g2.drawImage(((Tile) obj).getImage(), null, i * 64, j * 64);
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

        // Sync for cross-platform smooth rendering.
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Draws the tiles to the screen.
     */
    protected void drawTiles() {
        
    }

    /**
     * Draws the trees to the screen.
     */
    protected void drawTrees() {
        // Implement in a child class.
    }
    

}
