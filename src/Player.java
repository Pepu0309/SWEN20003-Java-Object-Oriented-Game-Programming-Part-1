import bagel.*;
public class Player extends GameEntity{
    private int energyLevel;

    public Player(String imageFilename, double xCoordinate, double yCoordinate, int energyLevel){
        super(imageFilename, xCoordinate, yCoordinate);
        this.energyLevel = energyLevel;
    }


}
