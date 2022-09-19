package us.charterbank.online.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;

public class OnlineBanking extends JFrame {
	JButton loginButton, exitButton, aboutButton;
    JLabel loginIndicator, userNameLabel, userPasswordLabel;
    JPanel mainPanel;
    JTextField userName, userPass;

    public static void main(String[] args) {
        new OnlineBanking();
    }

    public OnlineBanking() {
        this.setSize(500,500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int xPosition = (dimension.width / 2) - (this.getWidth() / 2);
        int yPosition = (dimension.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPosition, yPosition);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Charter Bank Online Banking");
        mainPanel = new JPanel();
        userNameLabel = new JLabel("User name:");
        userPasswordLabel = new JLabel("Password: ");
        userName = new JTextField("Type in your username", 20);
        userPass = new JTextField("Type in your password", 20);
        loginIndicator = new JLabel("Logged in...");
        aboutButton = new JButton("About");
        loginButton = new JButton("Log in");
        exitButton = new JButton("Exit app");
        mainPanel.add(userNameLabel);
        mainPanel.add(userName);
        mainPanel.add(userPasswordLabel);
        mainPanel.add(userPass);
        mainPanel.add(loginIndicator);
        mainPanel.add(aboutButton);
        mainPanel.add(loginButton);
        mainPanel.add(exitButton);
        loginIndicator.setVisible(false);
        ButtonListener buttonListener = new ButtonListener();
        loginButton.addActionListener(buttonListener);
        aboutButton.addActionListener(buttonListener);
        this.add(mainPanel);
        this.setVisible(true);
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent) {
            if(actionEvent.getSource() == loginButton){
                loginIndicator.setVisible(true);
            } else if (actionEvent.getSource() == aboutButton){
                JOptionPane.showMessageDialog(OnlineBanking.this, "This is an information message.", "About " + OnlineBanking.this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
