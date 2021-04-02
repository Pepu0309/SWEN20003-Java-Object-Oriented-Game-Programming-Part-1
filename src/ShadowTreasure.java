import bagel.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


/**
 * An example Bagel game.
 */
public class ShadowTreasure extends AbstractGame {

    static final double STEP_SIZE = 10;
    static final int FRAMES_PER_TICK = 10;

    // for rounding double number; use this to print the location of the player
    private static DecimalFormat df = new DecimalFormat("0.00");

    private Player player;
    private GameEntity zombie;
    private GameEntity sandwich;
    private Image background = new Image("res/images/background.png");

    private int frameCounter = 0;

    public static void printInfo(double x, double y, int e) {
        System.out.println(df.format(x) + "," + df.format(y) + "," + e);
    }

    public ShadowTreasure() throws IOException {
        super(900, 600, "Treasure Hunt");
        this.loadEnvironment("res/IO/environment.csv");
        // Add code to initialize other attributes as needed

        // Display initial positions of entities
        drawAll();
    }

    /**
     * Load from input file
     */
    private void loadEnvironment(String filename){
        // Using buffered reader and file reader to read from the environment.csv file.
        try (BufferedReader br =
                     new BufferedReader(new FileReader(filename))) {
            String fileText;

            // Reads each row of the file until there are no rows left to read.
            int csvRowCounter = 1;
            while ((fileText = br.readLine()) != null) {
                String[] currentCSVRow = fileText.split(",");

                // Checks which entity of the game the row is referring to in the csv file and then initializes it.
                if (csvRowCounter == 1){
                    player = new Player("res/images/player.png",Double.valueOf(currentCSVRow[1]),
                            Double.valueOf(currentCSVRow[2]), Integer.valueOf(currentCSVRow[3]));

                } else if (csvRowCounter == 2){
                    zombie = new Zombie("res/images/zombie.png",Double.valueOf(currentCSVRow[1]),
                            Double.valueOf(currentCSVRow[2]));

                } else if (csvRowCounter == 3){
                    sandwich = new Sandwich("res/images/sandwich.png",Double.valueOf(currentCSVRow[1]),
                            Double.valueOf(currentCSVRow[2]));
                }

                csvRowCounter++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Performs a state update.
     */
    @Override
    public void update(Input input) {
        // Logic to update the game, as per specification must go here
        frameCounter++;



        if(frameCounter % FRAMES_PER_TICK == 0) {

        }

        // Draws the images according to the coordinates that they are in
        drawAll();
    }

    // Display all entities to update their positions. Displays the static background first so it's behind.
    public void drawAll(){
        background.draw(0,0);
        player.drawEntity();
        zombie.drawEntity();
        sandwich.drawEntity();
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) throws IOException {
        ShadowTreasure game = new ShadowTreasure();
        game.run();
    }
}
