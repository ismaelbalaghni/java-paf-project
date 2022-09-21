package us.charterbank.online.views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import java.awt.event.*;

public class BankView extends JFrame {
	JButton loginButton = new JButton("Log in");
    JButton exitButton = new JButton("Exit app");
    JButton aboutButton = new JButton("About");
    JLabel loginIndicator = new JLabel("Logged in...");
    JLabel userNameLabel = new JLabel("User name:");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JPanel mainPanel = new JPanel();
    JTextField userName = new JTextField("Type in your username", 20);
    JTextField userPass = new JTextField("Type in your password", 20);

    public static void main(String[] args) {
        new BankView();
    }

    public BankView() {
        this.setSize(500,500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        int xPosition = (dimension.width / 2) - (this.getWidth() / 2);
        int yPosition = (dimension.height / 2) - (this.getHeight() / 2);

        this.setLocation(xPosition, yPosition);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Charter Bank Online Banking");

        mainPanel.setLayout(new GridBagLayout());

        Box box = Box.createVerticalBox();
        box.add(loginIndicator);
        box.add(Box.createVerticalStrut(10));
        box.add(loginButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
        buttonPanel.add(aboutButton);
        buttonPanel.add(exitButton);

        addComponent(mainPanel, userNameLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComponent(mainPanel, userName, 0, 0, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(mainPanel, userPasswordLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComponent(mainPanel, userPass, 0, 1, 2, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(mainPanel, box, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComponent(mainPanel, buttonPanel, 0, 2, 1, 1, GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE);

        loginIndicator.setVisible(false);
        ButtonListener buttonListener = new ButtonListener();
        aboutButton.addActionListener(buttonListener);
        this.add(mainPanel);
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent) {
            JOptionPane.showMessageDialog(BankView.this, "This is an information message.", "About " + BankView.this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void addComponent(JPanel panel, JComponent component, int x, int y, int width, int height, int anchor, int stretch){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = x;
        gridBagConstraints.gridy = y;
        gridBagConstraints.gridwidth = width;
        gridBagConstraints.gridheight = height;
        gridBagConstraints.weightx = 100;
        gridBagConstraints.weighty = 100;
        gridBagConstraints.anchor = anchor;
        gridBagConstraints.fill = stretch;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        panel.add(component, gridBagConstraints);
    }

    public void setLoginMessage(String loginMessage){
        loginIndicator.setText("Welcome " + loginMessage);
        loginIndicator.setVisible(true);
    }

    public String getUserName(){
        return userName.getText();
    }

    public String getUserPass(){
        return userPass.getText();
    }

    public void showErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage, this.getTitle(), JOptionPane.ERROR_MESSAGE);
    }

    public void addLoginListener(ActionListener actionListener){
        loginButton.addActionListener(actionListener);
    }

}
