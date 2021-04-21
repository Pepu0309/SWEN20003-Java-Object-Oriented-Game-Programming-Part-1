import bagel.*;
public class Player{
    // Player class which contains all attributes and behaviour associated with the player
    private final Image entityImage = new Image("res/images/player.png");
    private Point point;
    private static double STEP_SIZE = 10;
    private int energyLevel;

    public Player(double x, double y, int energyLevel){
        this.point = new Point(x, y);
        this.energyLevel = energyLevel;
    }


    // Method called to move the player towards a certain point, called once every step
    public void moveStep(Point point2){
        Point direction = calculateDirection(point2);
        this.getPoint().setX(this.getPoint().getX() + STEP_SIZE * direction.getX());
        this.getPoint().setY(this.getPoint().getY() + STEP_SIZE * direction.getY());
    }

    // Calculates normalised direction using formula in Week 5 Workshop and Project Specification
    private Point calculateDirection(Point point2){
        double directionX = (point2.getX() - this.getPoint().getX())/(this.getPoint().distanceTo(point2));
        double directionY = (point2.getY() - this.getPoint().getY())/(this.getPoint().distanceTo(point2));
        Point direction = new Point(directionX, directionY);
        return direction;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    // Draws entity on screen based on their coordinates
    public void drawEntity(){
        entityImage.draw(point.getX(), point.getY());
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
