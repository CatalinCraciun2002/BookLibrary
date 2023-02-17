package GUI;

import Database.LibraryDatabase;
import UsableClasses.User;

import javax.swing.*;
import java.awt.*;

public class MenuGUI extends JPanel {


    public JButton buttonLogOut = new JButton();
    private final JButton button1 = new JButton();
    private final JButton button2 = new JButton();
    private final JButton button3 = new JButton();
    private final JButton button4 = new JButton();

    private final HomeGUI homeGUI = new HomeGUI();
    private final JLabel actualUsername = new JLabel();
    private final JLabel usernameLabel = new JLabel();
    private final JLabel libraryTitleLabel = new JLabel();

    private final SearchGUI searchGUI;
    private final AddBookGUI addBookGUI;
    private final ManagerGUI managerGUI;
    private final LibraryDatabase db;


    public MenuGUI(LibraryDatabase database, User user) {

        super();

        this.db = database;

        searchGUI = new SearchGUI(db, user);
        addBookGUI = new AddBookGUI(db);
        managerGUI = new ManagerGUI(db);

        Dimension buttonSize = new Dimension();
        buttonSize.setSize(110, 50);

        Dimension usernameLabelSize = new Dimension();
        usernameLabelSize.setSize(80, 20);


        Font titleFont = new Font("Arial Black", Font.PLAIN, 24);

        usernameLabel.setLocation(15, 0);
        usernameLabel.setSize(usernameLabelSize);
        usernameLabel.setText("Username: ");
        usernameLabel.setHorizontalAlignment(JLabel.CENTER);

        actualUsername.setLocation(15, 20);
        actualUsername.setSize(usernameLabelSize);
        actualUsername.setText(user.getUsername());
        actualUsername.setHorizontalAlignment(JLabel.CENTER);

        libraryTitleLabel.setLocation(350, 10);
        libraryTitleLabel.setSize(600, 100);
        libraryTitleLabel.setFont(titleFont);
        libraryTitleLabel.setText("Cluj Napoca Library");
        libraryTitleLabel.setHorizontalAlignment(JLabel.CENTER);


        homeGUI.setBounds(150, 120, 1000, 600);
        searchGUI.setBounds(150, 120, 1000, 600);
        addBookGUI.setBounds(150, 120, 1000, 600);
        managerGUI.setBounds(150, 120, 1000, 600);


        buttonLogOut.setSize(80, 20);
        buttonLogOut.setLocation(10, 50);
        buttonLogOut.setText("Log out");


        button1.setSize(buttonSize);
        button1.setMaximumSize(buttonSize);
        button1.setLocation(10, 130);
        button1.setText("Home");
        button1.addActionListener(e -> {

            this.remove(this.getComponentCount() - 1);
            this.add(homeGUI);
            this.repaint();


        });

        button2.setSize(buttonSize);
        button2.setMaximumSize(buttonSize);
        button2.setLocation(10, 290);
        button2.setText("Search");
        button2.addActionListener(e -> {
            this.remove(this.getComponentCount() - 1);
            this.add(searchGUI);
            this.repaint();

        });

        button3.setSize(buttonSize);
        button3.setMaximumSize(buttonSize);
        button3.setLocation(10, 450);
        button3.setText("Add book");
        button3.addActionListener(e -> {

            if (user.getSecurityLevel() >= User.STAFF) {
                this.remove(this.getComponentCount() - 1);
                this.add(addBookGUI);
                this.repaint();
            } else {
                ErrorWindow.showErrorDialog("You have to be a Staff to access this");
            }
        });

        button4.setSize(buttonSize);
        button4.setMaximumSize(buttonSize);
        button4.setLocation(10, 600);
        button4.setText("Management");
        button4.addActionListener(e -> {

            if (user.getSecurityLevel() >= User.ADMIN) {
                this.remove(this.getComponentCount() - 1);
                this.add(managerGUI);
                this.repaint();
            } else {
                ErrorWindow.showErrorDialog("You have to be an Admin to access this");
            }
        });


        this.setBackground(Color.white);
        this.setLayout(null);


        this.add(actualUsername);
        this.add(usernameLabel);
        this.add(libraryTitleLabel);
        this.add(buttonLogOut);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);


        this.add(homeGUI);

    }

}
