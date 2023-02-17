package GUI;

import javax.swing.*;
import java.awt.*;

public class LogInGUI extends JPanel {

    public JButton loginButton = new JButton();
    private final JTextField usrnameFiled = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    public LogInGUI() {

        Dimension fieldSize = new Dimension(150, 30);

        usrnameFiled.setLocation(120, 100);
        usrnameFiled.setSize(fieldSize);

        passwordField.setLocation(120, 150);
        passwordField.setSize(fieldSize);

        loginButton.setLocation(145, 215);
        loginButton.setSize(100, 30);
        loginButton.setText("Log In");

        addComponents();

        this.setBackground(Color.BLUE);
        this.setLayout(null);


    }

    private void addComponents() {

        this.add(loginButton);
        this.add(usrnameFiled);
        this.add(passwordField);

    }

    public String getUsername() {

        String text = this.usrnameFiled.getText();
        this.usrnameFiled.setText("");
        return text;
    }

    public String getPassword() {

        String text = this.passwordField.getText();
        this.passwordField.setText("");

        return text;
    }


}
