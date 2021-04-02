import bagel.*;
public class GameEntity {
    private Image entityImage;
    private Point point;

    public GameEntity(String imageFilename, double x, double y){
        this.entityImage = new Image(imageFilename);
        this.point = new Point(x, y);
    }

    public Image getEntityImage() {
        return entityImage;
    }

    public void setEntityImage(Image entityImage) {
        this.entityImage = entityImage;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
