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
     *            - the number of trees to place in the area
     */
    public OurArea(int numberOfTrees) {
        super(); // A magic function. I wonder what it does?
        // * Exercise #1. Setup the tree objects at random locations.
        trees = new Tree[numberOfTrees];
        for (int i = 0; i < numberOfTrees; i++) {
            trees[i] = new Tree((int) (Math.random() * MAX_TREE_X), (int) (Math.random() * MAX_TREE_Y), "images/tree_1.png");
        }
        tiles = new Tile[NUM_TILES_X][NUM_TILES_Y];

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

        // draws a pond
        for (int i = 0; i <= 4; i++) {
            for (int k = 0; k <= 4; k++) {

                tiles[i][k] = new Water(i, k);
            }
        }
        // draws sand
        for (int i = 4; i > 0; i--) {
            for (int k = 0; k <= i; k++) {

                tiles[k][i] = new Sand(k, i);
            }

        }
        int xRan = (int) (Math.random() * NUM_TILES_X);
        int yRan = (int) (Math.random() * NUM_TILES_Y);

        tiles[xRan][yRan] = new Chest(xRan, yRan);

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

        // drawSprite(charater.getX(), charater.getY(), charater);

    }
}
