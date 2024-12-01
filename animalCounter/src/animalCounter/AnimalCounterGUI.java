package animalCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimalCounterGUI extends JFrame {

    private JLabel welcomeLabel, alligatorLabel, sheepLabel, blankLine;
    private JButton addAlligatorButton, addSheepButton, displayCountsButton, resetCountsButton, exitButton;
    private JRadioButton alligatorRadioButton, sheepRadioButton;
    private ButtonGroup radioGroup;

    private Alligator alligator;
    private Sheep sheep;

    public AnimalCounterGUI() {
        // Create the Sheep object first
        sheep = new Sheep();

        // Now create the Alligator object, passing the Sheep instance
        alligator = new Alligator(sheep);

        // Set up the window
        setTitle("Animal Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set the layout to BoxLayout to stack components vertically
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Create labels
        welcomeLabel = new JLabel("Welcome to the Animal Counter!");
        alligatorLabel = new JLabel("Alligator count: 0");
        sheepLabel = new JLabel("Sheep count: 0");
        blankLine = new JLabel("");  // Empty label for a blank line

        // Create buttons
        addAlligatorButton = new JButton("Add Alligator");
        addSheepButton = new JButton("Add Sheep");
        displayCountsButton = new JButton("Display Counts");
        resetCountsButton = new JButton("Reset Counts");
        exitButton = new JButton("Exit");

        // Create radio buttons
        alligatorRadioButton = new JRadioButton("Alligator");
        sheepRadioButton = new JRadioButton("Sheep");

        // Group radio buttons
        radioGroup = new ButtonGroup();
        radioGroup.add(alligatorRadioButton);
        radioGroup.add(sheepRadioButton);

        // Add components to the frame
        // Add welcome message centered
        JPanel welcomePanel = new JPanel();
        welcomePanel.add(welcomeLabel);
        welcomePanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Center the welcome label
        add(welcomePanel);

        // Add blank line (empty label)
        add(blankLine);

        // Add alligator and sheep count labels, centered
        JPanel countPanel = new JPanel();
        countPanel.add(alligatorLabel);
        countPanel.add(sheepLabel);
        countPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Center the count labels
        add(countPanel);

        // Add buttons for adding animals and displaying counts, centered
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addAlligatorButton);
        buttonPanel.add(addSheepButton);
        buttonPanel.add(displayCountsButton);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Center the action buttons
        add(buttonPanel);

        // Add radio buttons for reset selection, centered, placed above the reset button
        JPanel radioPanel = new JPanel();
        radioPanel.add(alligatorRadioButton);
        radioPanel.add(sheepRadioButton);
        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Center the radio buttons
        add(radioPanel);

        // Add reset counts button, centered
        JPanel resetPanel = new JPanel();
        resetPanel.add(resetCountsButton);
        resetPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Center the reset button
        add(resetPanel);

        // Add exit button, centered
        JPanel exitPanel = new JPanel();
        exitPanel.add(exitButton);
        exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));  // Center the exit button
        add(exitPanel);

        // Add button listeners
        addAlligatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alligator.incrementCount();
                alligatorLabel.setText("Alligator count: " + alligator.getCount());
            }
        });

        addSheepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sheep.incrementCount();
                sheepLabel.setText("Sheep count: " + sheep.getCount());
            }
        });

        displayCountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alligatorLabel.setText("Alligator count: " + alligator.getCount());
                sheepLabel.setText("Sheep count: " + sheep.getCount());
            }
        });

        resetCountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (alligatorRadioButton.isSelected()) {
                    alligator.resetCount();
                    alligatorLabel.setText("Alligator count: " + alligator.getCount());
                } else if (sheepRadioButton.isSelected()) {
                    sheep.resetCount();
                    sheepLabel.setText("Sheep count: " + sheep.getCount());
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Make the window visible
        setVisible(true);
    }
}
