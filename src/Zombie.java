import bagel.Image;

public class Zombie{
    // Zombie class which contains all attributes and behaviour associated with Sandwich

    private final Image entityImage = new Image("res/images/zombie.png");
    private static final int PLAYER_ENERGY_LOSS = 3;

    private Point point;

    public Zombie(double x, double y){
        this.point = new Point(x, y);
    }

    // Draws entity on screen based on their coordinates
    public void drawEntity(){
        entityImage.draw(point.getX(), point.getY());
    }

    public Point getPoint() {
        return point;
    }

    public static int getPlayerEnergyLoss() {
        return PLAYER_ENERGY_LOSS;
    }
}
