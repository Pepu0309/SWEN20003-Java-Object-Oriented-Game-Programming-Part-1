import bagel.*;
public class GameEntity {
    // Superclass of all Game Entities
    private Image entityImage;
    private Point point;

    public GameEntity(String imageFilename, double x, double y){
        this.entityImage = new Image(imageFilename);
        this.point = new Point(x, y);
    }

    // Draws entity on screen based on their coordinates
    public void drawEntity(){
        entityImage.draw(point.getX(), point.getY());
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
