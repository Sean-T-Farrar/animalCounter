package animalCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalCounterGUI {
    private final Alligator alligator = new Alligator();
    private final Sheep sheep = new Sheep();

    private JLabel alligatorLabel;
    private JLabel sheepLabel;
    private JRadioButton alligatorRadioButton;
    private JRadioButton sheepRadioButton;

    public AnimalCounterGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Animal Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(8, 1));

        // Welcome message
        JLabel welcomeLabel = new JLabel("Welcome to the Animal Counter!", SwingConstants.CENTER);
        frame.add(welcomeLabel);

        // Count labels
        alligatorLabel = new JLabel("Alligators: 0", SwingConstants.CENTER);
        sheepLabel = new JLabel("Sheep: 0", SwingConstants.CENTER);
        frame.add(alligatorLabel);
        frame.add(sheepLabel);

        // Add Alligator button
        JButton addAlligatorButton = new JButton("Add Alligator");
        addAlligatorButton.addActionListener(e -> {
            alligator.incrementCount();
            updateLabels();
        });
        frame.add(addAlligatorButton);

        // Add Sheep button
        JButton addSheepButton = new JButton("Add Sheep");
        addSheepButton.addActionListener(e -> {
            sheep.incrementCount();
            updateLabels();
        });
        frame.add(addSheepButton);

        // Display Counts button
        JButton displayCountsButton = new JButton("Display Counts");
        displayCountsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, 
                "Alligators: " + alligator.getCount() + "\nSheep: " + sheep.getCount(),
                "Current Counts", JOptionPane.INFORMATION_MESSAGE);
        });
        frame.add(displayCountsButton);

        // Reset Counts button and radio buttons
        JPanel resetPanel = new JPanel(new FlowLayout());
        alligatorRadioButton = new JRadioButton("Alligator");
        sheepRadioButton = new JRadioButton("Sheep");
        ButtonGroup resetGroup = new ButtonGroup();
        resetGroup.add(alligatorRadioButton);
        resetGroup.add(sheepRadioButton);
        resetPanel.add(alligatorRadioButton);
        resetPanel.add(sheepRadioButton);

        JButton resetCountsButton = new JButton("Reset Counts");
        resetCountsButton.addActionListener(e -> {
            if (alligatorRadioButton.isSelected()) {
                alligator.resetCount();
            } else if (sheepRadioButton.isSelected()) {
                sheep.resetCount();
            }
            updateLabels();
        });
        resetPanel.add(resetCountsButton);
        frame.add(resetPanel);

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));
        frame.add(exitButton);

        // Display the frame
        frame.setVisible(true);
    }

    private void updateLabels() {
        alligatorLabel.setText("Alligators: " + alligator.getCount());
        sheepLabel.setText("Sheep: " + sheep.getCount());
    }
}
