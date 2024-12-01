package animalCounter;

import javax.swing.JOptionPane;

public class Alligator extends AnimalData implements Countable {
    private Sheep sheep;  // Reference to the Sheep object to check the count

    // Constructor initializes count to zero
    public Alligator(Sheep sheep) {
        this.sheep = sheep;
        resetCount();
    }

    @Override
    public void incrementCount() {
        count++; // Increment alligator count by 1

        // If there are more alligators than sheep, show a message
        if (count > sheep.getCount()) {
            JOptionPane.showMessageDialog(null, "Please add more sheep for the hungry alligators");
        }

        // Deduct one sheep if there are any sheep available
        if (sheep.getCount() > 0) {
            sheep.decrementCount();
        }
    }

    @Override
    public void resetCount() {
        count = 0;

        // Display the message when alligator count is reset to zero
        JOptionPane.showMessageDialog(null, "No alligators now so the sheep are safe");
    }

    // Method to decrement count of alligators (used for the reset or when the count becomes zero)
    public void decrementCount() {
        if (count > 0) {
            count--; // Decrease the alligator count by 1
        }
        // If the count is now zero, show the message for no alligators
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "No alligators now so the sheep are safe");
        }
    }
}