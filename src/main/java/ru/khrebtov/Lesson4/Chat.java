package ru.khrebtov.Lesson4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Chat extends JFrame {

  private final JTextArea chatArea;
  private final JTextField message;

  public Chat() throws HeadlessException {
    setTitle("Chat");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(300, 300, 300, 400);

    setLayout(new BorderLayout());
    JPanel chatPanel = new JPanel();
    chatPanel.setLayout(new BorderLayout());
    JPanel messagePanel = new JPanel();
    messagePanel.setLayout(new BorderLayout());
    add(chatPanel, BorderLayout.CENTER);
    add(messagePanel, BorderLayout.PAGE_END);

    chatArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(chatArea);
    chatArea.setEditable(false);
    chatPanel.add(scrollPane, BorderLayout.CENTER);

    message = new JTextField();
    messagePanel.add(message, BorderLayout.CENTER);
    message.setBackground(Color.lightGray);
    JButton outputButton = new JButton("Отправить.");
    messagePanel.add(outputButton, BorderLayout.EAST);
    outputButton.addActionListener(e -> sendMessage());
    message.addActionListener(e -> sendMessage());

    JMenuBar mainMenu = new JMenuBar();
    JMenu mFile = new JMenu("File");

    JMenuItem miFileExit = new JMenuItem("Exit");

    setJMenuBar(mainMenu);
    mainMenu.add(mFile);
    mFile.add(miFileExit);

    miFileExit.addActionListener(e -> System.exit(0));

    setVisible(true);
  }

  private void sendMessage() {
    StringBuilder textIntoChat = new StringBuilder(chatArea.getText());
    chatArea
        .setText(textIntoChat.append(message.getText()).append(System.lineSeparator()).toString());
    message.setText("");
  }

}
