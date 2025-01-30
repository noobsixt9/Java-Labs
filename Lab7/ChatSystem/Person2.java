// Shivaram Chalise (222036)

package Lab7.ChatSystem;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Person2 {
    private static JTextArea chatArea;
    private static JTextField chatBox;
    private static PrintWriter writer;

    public static void main(String[] a) {

        JFrame frame = new JFrame("Chat - Person2");
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
        chatBox = new JTextField(); // Message input text field
        JButton sendButton = new JButton("Send"); // Send button

        inputPanel.add(chatBox, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        // Start server
        new Thread(Person2::startServer).start();

        // Send button action
        sendButton.addActionListener(e -> sendMessage());

        // Pressing Enter in chatBox
        chatBox.addActionListener(e -> sendMessage());
    }

    private static void sendMessage() {
        String message = chatBox.getText().trim();

        if (!message.isEmpty() && writer != null) {
            writer.println(message); // Send to client
            chatArea.append("You: " + message + "\n"); // Show in chat
            chatBox.setText(""); // Clear input
        }
    }

    private static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(123)) {
            Socket clientSocket = serverSocket.accept();

            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String name = JOptionPane.showInputDialog("Enter your name: ");

            String message;
            while ((message = reader.readLine()) != null) {
                chatArea.append(name + ": " + message + "\n");
            }
        } catch (IOException e) {
            chatArea.append("Error in server: " + e.getMessage() + "\n");
        }
    }
}