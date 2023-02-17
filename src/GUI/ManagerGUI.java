package GUI;

import Database.LibraryDatabase;

import javax.swing.*;
import java.awt.*;

public class ManagerGUI extends JPanel {

    private final LibraryDatabase db;

    private final JButton deleteButton = new JButton();
    private final ClearTextArea idEnterTextFiled = new ClearTextArea();


    public ManagerGUI(LibraryDatabase database) {

        this.db = database;

        this.setBackground(Color.GRAY);

        deleteButton.setText("Delete");
        deleteButton.setSize(100, 50);
        deleteButton.setLocation(300, 200);
        deleteButton.addActionListener(e -> {

            try {
                int id = Integer.parseInt(idEnterTextFiled.getText());
                if (db.getBookModifier().deleteBook(id)) {
                    idEnterTextFiled.setText("Book deleted");
                } else {
                    idEnterTextFiled.setText("Failed to delete the book");
                }

            } catch (Exception error) {
                idEnterTextFiled.setText("Failed to delete the book");
            }


        });

        idEnterTextFiled.setText("Enter the id of the book to be deleted");
        idEnterTextFiled.setSize(300, 50);
        idEnterTextFiled.setLocation(420, 200);
        idEnterTextFiled.addActionListener(e -> {
            idEnterTextFiled.setText("");
        });

        addComponents();
    }

    private void addComponents() {

        this.add(deleteButton);
        this.add(idEnterTextFiled);
        this.setLayout(null);
    }

}
