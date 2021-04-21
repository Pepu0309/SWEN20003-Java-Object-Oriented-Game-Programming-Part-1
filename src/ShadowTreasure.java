import bagel.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * An example Bagel game.
 */
public class ShadowTreasure extends AbstractGame {


    static final int FRAMES_PER_TICK = 10;

    // for rounding double number; use this to print the location of the player
    private static DecimalFormat df = new DecimalFormat("0.00");

    private Player player;
    private Zombie zombie;
    private Sandwich sandwich;
    private static final Image background = new Image("res/images/background.png");

    private int frameCounter = 0;

    private static final Font energyFont = new Font("res/font/DejaVuSans-Bold.ttf", 20);

    public static void printInfo(double x, double y, int e) {
        System.out.println(df.format(x) + "," + df.format(y) + "," + e);
    }

    public ShadowTreasure() throws IOException {
        this.loadEnvironment("res/IO/environment.csv");
        // Add code to initialize other attributes as needed

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
            while ((fileText = br.readLine()) != null) {

                /* Replaces all occurrences of non-alphanumerical, comma or dot characters with an empty string,
                 * using regex expression [^,.a-zA-z0-9]+. Code referenced from
                 * https://stackoverflow.com/questions/39672094/
                 * how-to-remove-all-special-character-in-a-string-except-dot-and-comma/39672126 and modified for use.
                 */
                fileText = fileText.replaceAll("[^,.a-zA-z0-9]+", "");
                String[] currentCSVRow = fileText.split(",");

                String entityType = currentCSVRow[0];
                // Checks which entity of the game the row is referring to in the csv file and then initializes it.
                if (entityType.equals("Player")){
                    player = new Player(Double.valueOf(currentCSVRow[1]), Double.valueOf(currentCSVRow[2]),
                            Integer.valueOf(currentCSVRow[3]));

                } else if (entityType.equals("Zombie")){
                    zombie = new Zombie(Double.valueOf(currentCSVRow[1]), Double.valueOf(currentCSVRow[2]));

                } else if (entityType.equals("Sandwich")){
                    sandwich = new Sandwich(Double.valueOf(currentCSVRow[1]), Double.valueOf(currentCSVRow[2]));
                }
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

        // Increment frame counter to keep track of current frame
        frameCounter++;

        // Draws the images according to the coordinates that they are in
        displayAll();

        // Updates the game status every 10 ticks
        if(frameCounter % FRAMES_PER_TICK == 0) {
            updateTick();
        }

    }

    // Display all entities to update their positions. Displays the static background first so it's behind.
    public void displayAll(){
        background.drawFromTopLeft(0,0);
        player.drawEntity();
        zombie.drawEntity();
        if(sandwich.isEaten() == false){
            sandwich.drawEntity();
        }
        energyFont.drawString(String.format("energy: %d", player.getEnergyLevel()), 20, 760);
    }

    // Method called to update the game status every tick
    public void updateTick(){

        // Algorithm 1 from the specification, called every game tick
        if (player.getPoint().meet(zombie.getPoint())){
            player.setEnergyLevel(player.getEnergyLevel() - 3);

            // prints information of the player right before game is terminated
            printInfo(player.getPoint().getX(), player.getPoint().getY(), player.getEnergyLevel());
            System.exit(0);

        } else if (player.getPoint().meet(sandwich.getPoint()) && sandwich.isEaten() == false){
            player.setEnergyLevel(player.getEnergyLevel() + 5);
            sandwich.setEaten(true);
        }

        // prints the information of the player right before moving
        printInfo(player.getPoint().getX(), player.getPoint().getY(), player.getEnergyLevel());
        if (player.getEnergyLevel() >= 3){
            player.moveStep(zombie.getPoint());
        } else {
            player.moveStep(sandwich.getPoint());
        }

    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) throws IOException {
        ShadowTreasure game = new ShadowTreasure();
        game.run();
    }
}
