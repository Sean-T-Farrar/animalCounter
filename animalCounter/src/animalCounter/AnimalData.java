package animalCounter;

public abstract class AnimalData {
    protected int count;

    public AnimalData() {
        this.count = 0;
    }

    public void resetCount() {
        this.count = 0;
    }

    public int getCount() {
        return count;
    }
}