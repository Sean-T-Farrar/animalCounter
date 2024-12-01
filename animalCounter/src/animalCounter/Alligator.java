package animalCounter;

public class Alligator extends AnimalData implements Countable {
    @Override
    public void incrementCount() {
        count++;
    }
}