import bagel.*;
public class Player extends GameEntity{
    private int energyLevel;

    public Player(String imageFilename, double x, double y, int energyLevel){
        super(imageFilename, x, y);
        this.energyLevel = energyLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
}
