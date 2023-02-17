package GUI;

import javax.swing.*;

public class ErrorWindow extends JPanel {

    public static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Access denied", JOptionPane.ERROR_MESSAGE);
    }

    public static void showSubmitSuccessfulDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Action successful", JOptionPane.INFORMATION_MESSAGE);
    }
}
