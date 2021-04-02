import bagel.*;
public class GameEntity {
    private Image entityImage;
    private double xCoordinate;
    private double yCoordinate;

    public GameEntity(String imageFilename, double xCoordinate, double yCoordinate){
        this.entityImage = new Image(imageFilename);
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Image getEntityImage() {
        return entityImage;
    }

    public void setEntityImage(Image entityImage) {
        this.entityImage = entityImage;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
