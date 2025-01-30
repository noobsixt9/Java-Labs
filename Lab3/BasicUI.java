// Shivaram Chalise (222036)
package Lab3;

import javax.swing.*;
import java.awt.*;

public class BasicUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

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
        JComboBox<String> genderComboBox = new JComboBox<>();
        genderComboBox.addItem("BCA");
        genderComboBox.addItem("BECE");
        genderComboBox.addItem("BEIT");
        panel.add(genderComboBox, gbc);

        // Text area for 'About Yourself'
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("About Yourself:"), gbc);

        gbc.gridx = 1;
        JTextArea aboutYourself = new JTextArea();
        aboutYourself.setColumns(15);
        aboutYourself.setRows(5);
        panel.add(aboutYourself, gbc);

        // Add submit button
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton submitButton = new JButton("Submit");
        panel.add(submitButton, gbc);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
