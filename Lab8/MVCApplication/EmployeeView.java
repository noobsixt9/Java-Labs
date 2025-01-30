package Lab8.MVCApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EmployeeView extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField addressField;
    private JTextField positionField;
    private JButton submitButton;
    private JLabel messageLabel;

    public EmployeeView() {
        // Set up the frame
        setTitle("Employee Details");
        setSize(400, 300);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);

        gbc.gridy = 1;
        add(new JLabel("Age:"), gbc);

        gbc.gridy = 2;
        add(new JLabel("Address:"), gbc);

        gbc.gridy = 3;
        add(new JLabel("Position:"), gbc);

        nameField = new JTextField(15);
        ageField = new JTextField(15);
        addressField = new JTextField(15);
        positionField = new JTextField(15);
        submitButton = new JButton("Submit");
        messageLabel = new JLabel("");

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameField, gbc);

        gbc.gridy = 1;
        add(ageField, gbc);

        gbc.gridy = 2;
        add(addressField, gbc);

        gbc.gridy = 3;
        add(positionField, gbc);

        gbc.gridy = 4;
        add(submitButton, gbc);

        gbc.gridy = 5;
        add(messageLabel, gbc);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getName() {
        return nameField.getText();
    }

    public String getAge() {
        //return Integer.parseInt(ageField.getText());
        return ageField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public String getPosition() {
        return positionField.getText();
    }

    public void setMessage(String message) {
        messageLabel.setText(message);
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        EmployeeView ev = new EmployeeView();

    }
}