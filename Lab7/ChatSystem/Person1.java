// Shivaram Chalise (222036)

package Lab7.ChatSystem;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Person1 {
    private static JTextArea chatArea;
    private static JTextField chatBox;
    private static PrintWriter writer;

    public static void main(String[] a) {
        JFrame frame = new JFrame("Chat - Person1");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Chat display area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        chatBox = new JTextField(); // Message input field
        JButton sendButton = new JButton("Send"); // Send button

        inputPanel.add(chatBox, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        // Connect to server
        new Thread(Person1::makeConnection).start();

        // Send button action
        sendButton.addActionListener(e -> sendMessage());

        // Pressing Enter in chatBox
        chatBox.addActionListener(e -> sendMessage());
    }

    private static void sendMessage() {
        String message = chatBox.getText().trim();
        if (!message.isEmpty() && writer != null) {
            writer.println(message); // Send to server
            chatArea.append("You: " + message + "\n"); // Show in chat
            chatBox.setText(""); // Clear input
        }
    }

    private static void makeConnection() {
        try (Socket socket = new Socket("localhost", 123)) {
            writer = new PrintWriter(socket.getOutputStream(), true); // For sending message

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // For receiving message
            String message;
            String name = JOptionPane.showInputDialog("Enter your name: ");

            while ((message = reader.readLine()) != null) {
                chatArea.append(name + ": " + message + "\n"); // Display received message
            }
        } catch (IOException e) {
            chatArea.append("Error connecting to server: " + e.getMessage() + "\n");
        }
    }
}