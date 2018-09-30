import java.awt.event.KeyEvent;

/**
 * Provides the base model implementation for the Area class. Represents a Window constructed out of 64 x 64 tiles.
 * @author jddevaughnbrown
 *
 */
@SuppressWarnings("serial")
public class OurArea extends Area {

    /*
     * Variables from the parent class we have access to // The trees that are scattered around the area. Tree[] trees; //
     * The area tile map, with each tile represented as an integer. int[][] tiles; // The tile values for grass (0) and stone
     * (1) tiles. int GRASS; int STONE; // The number of tiles on the x-axis, and y-axis. int NUM_TILES_X; int NUM_TILES_Y;
     * // The maximum position of a tree on the x-axis and y-axis. // Note: The minimum is simply (0, 0). double MAX_TREE_X;
     * double MAX_TREE_Y;
     */

    /**
     * Constructs the OurArea.
     * @param numberOfTrees
     *      - the number of trees to place in the area
     */
    // if the sprite has gotten the spear
    private boolean hasSpear;

    public OurArea(int numberOfTrees) {
        super(); // A magic function. I wonder what it does?
        // * Exercise #1. Setup the tree objects at random locations.
        trees = new Tree[numberOfTrees];
        for (int i = 0; i < numberOfTrees; i++) {
            trees[i] = new Tree((int) (Math.random() * MAX_TREE_X), (int) (Math.random() * MAX_TREE_Y), "images/tree_1.png");
        }
        tiles = new Tile[NUM_TILES_X][NUM_TILES_Y];
        spritePosition = new Sprite[NUM_TILES_X][NUM_TILES_Y];
        sprite = new Sprite(5, 5, "file:images/MainSprite/standing_sprite.png");

        int xRan = (int) (Math.random() * NUM_TILES_X);
        int yRan = (int) (Math.random() * NUM_TILES_Y);

        // */

        // * Exercise #3. Initialize the tiles.
        for (int i = 0; i < NUM_TILES_X; i++) {
            for (int j = 0; j < NUM_TILES_Y; j++) {
                // Example: Default to grass everywhere.
                tiles[i][j] = new Grass(i, j);

            }
        }

        // Example: Draw two stones at specific locations.
        tiles[6][2] = new Stone(6, 2);
        tiles[5][7] = new Stone(5, 7);

        // */

        /**
         * sets up a pond (initializes)
         */
        for (int i = 0; i <= 4; i++) {
            for (int k = 0; k <= 4; k++) {

                tiles[i][k] = new Water(i, k);
            }
        }
        /**
         * sets up sand (initializes)
         */
        for (int i = 4; i > 0; i--) {
            for (int k = 0; k <= i; k++) {

                tiles[k][i] = new Sand(k, i);
            }

        }

        /**
        * draws treasure chest at a random location on the screen (initializes)
        */
        tiles[xRan][yRan] = new Chest(xRan, yRan);

        spritePosition[5][5] = sprite;
    }

    @Override
    protected void drawSprites() {

        spritePosition[sprite.getX()][sprite.getY()] = sprite;
        drawSprite(sprite.getX(), sprite.getY());
        // if sprite is on chest tile, open chest and get spear
        if ("class Chest".equals((tiles[sprite.getX()][sprite.getY()]).getType())) {
            tiles[sprite.getX()][sprite.getY()] = new OpenChest(sprite.getX(), sprite.getY());
            sprite = new SpriteWithSpear(sprite.getX(), sprite.getY());
            hasSpear = true;
            // if sprite is on water tile, swim
        } else if ("class Water".equals((tiles[sprite.getX()][sprite.getY()]).getType())) {
            sprite = new SwimmingSprite(sprite.getX(), sprite.getY());
            // if space is pressed while spear is held, attack
        } else if (hasSpear) {
            if (sprite.isAttacking()) {
                sprite = new SpriteAttack(sprite.getX(), sprite.getY());
            } else {
                sprite = new SpriteWithSpear(sprite.getX(), sprite.getY());
            }
        } else {
            sprite = new Sprite(sprite.getX(), sprite.getY(), "file:images/MainSprite/standing_sprite.png");
        }

        repaint();
    }

    @Override
    protected void drawTrees() {
        // * Exercise #2. Draw the trees.
        for (int i = 0; i < trees.length; i++) {
            drawTree(i);
        }
        // */
    }

    @Override
    protected void drawTiles() {
        // * Exercise #4. Draw the tiles.
        for (int i = 0; i < NUM_TILES_X; i++) {
            for (int j = 0; j < NUM_TILES_Y; j++) {

                drawTile(i, j);
            }
        }

    }

}
