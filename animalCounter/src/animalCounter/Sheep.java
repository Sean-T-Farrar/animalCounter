package animalCounter;

public class Sheep extends AnimalData implements Countable {
    @Override
    public void incrementCount() {
        count += 2;
    }
}