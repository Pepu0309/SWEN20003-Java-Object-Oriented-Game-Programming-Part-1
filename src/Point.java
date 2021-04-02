public class Point {
    // Class that represents a coordinate
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // public double distanceTo(Point point2){ }

    public double getX() {
        return x;
    }

    public void setXCoordinate(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setYCoordinate(double y) {
        this.y = y;
    }
}
