package animalCounter;

public class Sheep extends AnimalData implements Countable {

    public Sheep() {
        resetCount();
    }

    @Override
    public void incrementCount() {
        count += 2; // Add 2 sheep
    }

    // This method is added to decrement the sheep count by 1
    public void decrementCount() {
        if (count > 0) {
            count--; // Decrease the sheep count by 1
        }
    }

    @Override
    public void resetCount() {
        count = 0;
    }
}
