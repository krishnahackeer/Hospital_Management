package actionl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class action extends JFrame implements ActionListener {
    JRadioButton rb1, rb2, rb3;
    JButton submitButton;

    public action() {
        // Create radio buttons
        rb1 = new JRadioButton("Option 1");
        rb1.setBounds(50, 50, 100, 30);
        rb2 = new JRadioButton("Option 2");
        rb2.setBounds(50, 100, 100, 30);
        rb3 = new JRadioButton("Option 3");
        rb3.setBounds(50, 150, 100, 30);

        // Add radio buttons to a ButtonGroup
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);

        // Create a submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 200, 100, 30);
        submitButton.addActionListener(this);

        // Add radio buttons and submit button to the frame
        add(rb1);
        add(rb2);
        add(rb3);
        add(submitButton);

        // Frame settings
        setTitle("RadioButton Example");
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String selectedOption = null;
            if (rb1.isSelected()) {
                selectedOption = rb1.getText();
            } else if (rb2.isSelected()) {
                selectedOption = rb2.getText();
            } else if (rb3.isSelected()) {
                selectedOption = rb3.getText();
            }
            JOptionPane.showMessageDialog(this, "Selected Option: " + selectedOption);
        }
    }

    public static void main(String[] args) {
        new action(); // Create an instance of the class
    }
}
