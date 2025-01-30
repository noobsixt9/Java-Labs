// Shivaram Chalise (222036)

package Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class FormExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);

        // Panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Label for 'Name'
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Name:"), gbc);

        // Text Field for name
        gbc.gridx = 1;
        JTextField nameField = new JTextField(15);
        panel.add(nameField, gbc);

        // Label for 'Email'
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Email:"), gbc);

        // Text field for email
        gbc.gridx = 1;
        JTextField emailField = new JTextField(15);
        panel.add(emailField, gbc);

        // Label for 'Gender'
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Gender:"), gbc);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Sub-panel for radio buttons
        //  Radio buttons for Gender (Male, Female, Other)
        JRadioButton maleRadioButton = new JRadioButton("Male");
        JRadioButton femaleRadioButton = new JRadioButton("Female");
        JRadioButton otherRadioButton = new JRadioButton("Other");

        // Grouping the radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderGroup.add(otherRadioButton);

        // Add radio button to the sub-panel
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        genderPanel.add(otherRadioButton);

        // Add sub-panel to the main panel
        gbc.gridx = 1;
        panel.add(genderPanel, gbc);

        // Label for 'Program'
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Program:"), gbc);

        // Combo box for Program
        gbc.gridx = 1;
        JComboBox<String> programComboBox = new JComboBox<>();
        programComboBox.addItem("BCA");
        programComboBox.addItem("BECE");
        programComboBox.addItem("BEIT");
        panel.add(programComboBox, gbc);

        // Add submit button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameField.getText();
                String email = emailField.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : (femaleRadioButton.isSelected() ? "Female" : "Other");
                String program = (String) programComboBox.getSelectedItem();

                String filename = JOptionPane.showInputDialog("Enter the filename: ");
                if (filename == null || filename.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Filename cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try (FileWriter fw = new FileWriter(filename + ".txt")) {
                    fw.write("Name: " + name);
                    fw.write("\nEmail: " + email);
                    fw.write("\nGender: " + gender);
                    fw.write("\nProgram: " + program);

                    JOptionPane.showMessageDialog(panel, "Successfully Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        });

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}