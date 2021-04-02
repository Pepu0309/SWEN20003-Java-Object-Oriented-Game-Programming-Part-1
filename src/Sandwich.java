public class Sandwich extends GameEntity{
    // Subclass Sandwich which is a Game Entity
    private boolean isEaten;

    public Sandwich(String imageFilename, double x, double y){
        super(imageFilename, x, y);
        this.isEaten = false;
    }

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }
}

