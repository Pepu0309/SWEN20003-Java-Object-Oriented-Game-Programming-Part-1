public class Point {
    // Class that represents a coordinate
    private static final double MEET_CONDITION = 50;
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point2){
        return Math.sqrt(Math.pow((this.x - point2.getX()), 2) + Math.pow((this.y - point2.getY()), 2));
    }

    // Determines whether a point meets with another point with respect to definition
    public boolean meet(Point point2){
        if(distanceTo(point2) < MEET_CONDITION){
            return true;
        }
        return false;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
