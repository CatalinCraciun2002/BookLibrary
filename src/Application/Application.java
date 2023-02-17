package Application;

import Database.LibraryDatabase;
import GUI.ErrorWindow;
import GUI.LogInGUI;
import GUI.MenuGUI;
import UsableClasses.Admin;
import UsableClasses.Member;
import UsableClasses.Staff;
import UsableClasses.User;

import javax.swing.*;
import java.awt.*;


public class Application extends JFrame {


    private Container container;
    private final LibraryDatabase db;

    private LogInGUI logInGUI;

    public Application() {

        db = new LibraryDatabase();
        initializeWindow();

    }

    public static void main(String[] args) {
        new Application();
    }

    private MenuGUI createMenuGUI(User username) {

        MenuGUI menu = new MenuGUI(db, username);
        menu.setBounds(0, 0, 1200, 800);
        menu.buttonLogOut.addActionListener(e -> {
            container.remove(container.getComponentCount() - 1);
            container.add(logInGUI);
            setSize(400, 400);
            container.repaint();

        });

        return menu;

    }

    private void loginAction() {

        String username = logInGUI.getUsername();
        String password = logInGUI.getPassword();

        System.out.println(username);
        System.out.println(password);

        int userAuthority = db.checkCredentials(username, password);

        System.out.println(userAuthority);

        if (userAuthority == -1) {
            ErrorWindow.showErrorDialog("Incorrect Username or Password");
        } else {
            container.remove(container.getComponentCount() - 1);

            User user;

            if (userAuthority == User.STAFF) {
                user = new Staff(username, db.getFirstName(), db.getLastName());
            } else if (userAuthority == User.ADMIN) {
                user = new Admin(username, db.getFirstName(), db.getLastName());
            } else {
                user = new Member(username, db.getFirstName(), db.getLastName());
            }

            container.add(createMenuGUI(user));

            setSize(1200, 800);
        }

    }

    private void initializeWindow() {

        setTitle("Welcome");

        container = getContentPane();
        container.setLayout(null);

        // Log In GUI initialization

        logInGUI = new LogInGUI();
        logInGUI.setBounds(0, 0, 400, 400);
        logInGUI.loginButton.addActionListener(e -> loginAction());


        // Setting the window options

        container.add(logInGUI);
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
