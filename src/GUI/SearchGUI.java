package GUI;

import Database.LibraryDatabase;
import UsableClasses.Book;
import UsableClasses.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class SearchGUI extends JPanel implements AddingInterface<Book> {

    final int startSecondColumn = 140;
    int pozBeforeQuery = -1;
    ArrayList<String> attributes = new ArrayList<String>();
    ArrayList<String> values = new ArrayList<String>();
    String separator = ", ";
    private final JButton searchButton = new JButton();
    private final JCheckBox idCheckBox = new JCheckBox();
    private final JCheckBox titleCheckBox = new JCheckBox();
    private final JCheckBox authorCheckBox = new JCheckBox();
    private final JCheckBox publicationCheckBox = new JCheckBox();
    private final JCheckBox genreCheckBox = new JCheckBox();
    private final JCheckBox publicationDateCheckBox = new JCheckBox();
    private final JTextArea searchField = new JTextArea();
    private String searchText;
    private final LibraryDatabase db;
    private final User user;
    private int nextObjectLocation = 110;

    public SearchGUI(LibraryDatabase database, User user) {

        super();

        this.db = database;
        this.user = user;

        Dimension searchCriterionCheckDimension = new Dimension();
        searchCriterionCheckDimension.setSize(120, 50);

        this.setBackground(Color.LIGHT_GRAY);

        searchField.setSize(800, 30);
        searchField.setLocation(startSecondColumn, 20);
        searchField.setFont(new Font("Arial Black", Font.PLAIN, 16));


        searchButton.setSize(110, 30);
        searchButton.setLocation(10, 20);
        searchButton.setText("Search");
        searchButton.addActionListener(e -> {

            clearLastQuerry();
            this.searchText = this.searchField.getText();
            addQuerry();

        });

        int CheckBoxStartLocation = 80;

        if (user.getSecurityLevel() == User.ADMIN) {
            CheckBoxStartLocation = 130;
        }


        idCheckBox.setLocation(10, 80);
        idCheckBox.setSize(searchCriterionCheckDimension);
        idCheckBox.setText("By id");
        idCheckBox.setBackground(this.getBackground());


        titleCheckBox.setLocation(10, CheckBoxStartLocation);
        titleCheckBox.setSize(searchCriterionCheckDimension);
        titleCheckBox.setText("By title");
        titleCheckBox.setBackground(this.getBackground());

        authorCheckBox.setLocation(10, CheckBoxStartLocation + 50);
        authorCheckBox.setSize(searchCriterionCheckDimension);
        authorCheckBox.setText("By author");
        authorCheckBox.setBackground(this.getBackground());

        publicationCheckBox.setLocation(10, CheckBoxStartLocation + 100);
        publicationCheckBox.setSize(searchCriterionCheckDimension);
        publicationCheckBox.setText("By publication");
        publicationCheckBox.setBackground(this.getBackground());

        genreCheckBox.setLocation(10, CheckBoxStartLocation + 150);
        genreCheckBox.setSize(searchCriterionCheckDimension);
        genreCheckBox.setText("By genre");
        genreCheckBox.setBackground(this.getBackground());

        publicationDateCheckBox.setLocation(10, CheckBoxStartLocation + 200);
        publicationDateCheckBox.setSize(searchCriterionCheckDimension);
        publicationDateCheckBox.setText("By release date");
        publicationDateCheckBox.setBackground(this.getBackground());


        addElements();


        //this.setBackground(Color.BLACK);


    }

    private void addLabels() {

        nextObjectLocation -= 50;


        int idWidth = 0;
        int titleWidth = 120;
        int authorWidth = 100;
        int publicationWidth = 120;
        int genreWidth = 90;
        int locationWidth = 70;
        int dateWidth = 120;

        int idPoz = this.startSecondColumn;

        if (user.getSecurityLevel() == User.ADMIN) {

            idWidth = 40;
            titleWidth -= 10;
            authorWidth -= 10;
            publicationWidth -= 10;
            genreWidth -= 20;

            JLabel idLabel = new JLabel("Id", SwingConstants.CENTER);

            idLabel.setSize(idWidth, 40);
            idLabel.setLocation(idPoz, nextObjectLocation);
            this.add(idLabel);

            idWidth += 10;
        }

        int titlePoz = idPoz + idWidth + 70;
        JLabel titleLable = new JLabel();
        titleLable.setText("Title");
        titleLable.setSize(titleWidth, 40);
        titleLable.setLocation(titlePoz, nextObjectLocation);

        int authorPoz = titlePoz + titleWidth + 50;
        JLabel authorLable = new JLabel();
        authorLable.setText("Author");
        authorLable.setSize(authorWidth, 40);
        authorLable.setLocation(authorPoz, nextObjectLocation);

        int publicationPoz = authorPoz + authorWidth + 30;
        JLabel publicationLable = new JLabel();
        publicationLable.setText("Publication");
        publicationLable.setSize(publicationWidth, 40);
        publicationLable.setLocation(publicationPoz, nextObjectLocation);

        int genrePoz = publicationPoz + publicationWidth + 40;
        JLabel genreLable = new JLabel();
        genreLable.setText("Genre");
        genreLable.setSize(genreWidth, 40);
        genreLable.setLocation(genrePoz, nextObjectLocation);

        int locationPoz = genrePoz + genreWidth + 25;
        JLabel locationLable = new JLabel();
        locationLable.setText("Location");
        locationLable.setSize(locationWidth, 40);
        locationLable.setLocation(locationPoz, nextObjectLocation);


        int datePoz = locationPoz + locationWidth + 15;
        JLabel dateLable = new JLabel();
        dateLable.setText("PublicationDate");
        dateLable.setSize(dateWidth, 40);
        dateLable.setLocation(datePoz, nextObjectLocation);


        this.add(titleLable);
        this.add(authorLable);
        this.add(publicationLable);
        this.add(genreLable);
        this.add(locationLable);
        this.add(dateLable);

        nextObjectLocation += 50;


    }

    private void addElements() {

        this.setLayout(null);

        if (user.getSecurityLevel() == User.ADMIN)
            this.add(idCheckBox);

        this.add(searchButton);
        this.add(titleCheckBox);
        this.add(authorCheckBox);
        this.add(publicationCheckBox);
        this.add(genreCheckBox);
        this.add(publicationDateCheckBox);
        this.add(searchField);
        addLabels();

        pozBeforeQuery = this.getComponentCount();
    }

    @Override
    public void addEntry(Book entry) {

        int idWidth = 0;
        int titleWidth = 170;
        int authorWidth = 130;
        int publicationWidth = 130;
        int genreWidth = 140;
        int locationWidth = 70;
        int dateWidth = 80;

        int idPoz = this.startSecondColumn;

        if (user.getSecurityLevel() == User.ADMIN) {

            idWidth = 40;
            titleWidth -= 10;
            authorWidth -= 10;
            publicationWidth -= 10;
            genreWidth -= 20;

            JLabel idLable = new JLabel(String.valueOf(entry.getId()), SwingConstants.CENTER);

            idLable.setSize(idWidth, 40);
            idLable.setLocation(idPoz, nextObjectLocation);
            this.add(idLable);

            idWidth += 10;
        }

        int titlePoz = idPoz + idWidth;
        JLabel titleLable = new JLabel(entry.getTitle(), SwingConstants.CENTER);

        titleLable.setSize(titleWidth, 40);
        titleLable.setLocation(titlePoz, nextObjectLocation);

        int authorPoz = titlePoz + titleWidth + 20;
        JLabel authorLable = new JLabel(entry.getAuthor(), SwingConstants.CENTER);

        authorLable.setSize(authorWidth, 40);
        authorLable.setLocation(authorPoz, nextObjectLocation);

        int publicationPoz = authorPoz + authorWidth + 20;
        JLabel publicationLable = new JLabel(entry.getPublication(), SwingConstants.CENTER);

        publicationLable.setSize(publicationWidth, 40);
        publicationLable.setLocation(publicationPoz, nextObjectLocation);

        int genrePoz = publicationPoz + publicationWidth + 20;
        JLabel genreLable = new JLabel(entry.getGenre(), SwingConstants.CENTER);

        genreLable.setSize(genreWidth, 40);
        genreLable.setLocation(genrePoz, nextObjectLocation);

        int locationPoz = genrePoz + genreWidth + 20;
        JLabel locationLable = new JLabel(entry.getLocation(), SwingConstants.CENTER);
        locationLable.setSize(locationWidth, 40);
        locationLable.setLocation(locationPoz, nextObjectLocation);


        int datePoz = locationPoz + locationWidth + 20;
        JLabel dateLable = new JLabel(entry.getPublicationDate().toString(), SwingConstants.CENTER);
        dateLable.setSize(dateWidth, 40);
        dateLable.setLocation(datePoz, nextObjectLocation);


        this.add(titleLable);
        this.add(authorLable);
        this.add(publicationLable);
        this.add(genreLable);
        this.add(locationLable);
        this.add(dateLable);

        nextObjectLocation += 50;

    }

    private void addValues(JCheckBox checkBox) {

        if (checkBox.isSelected()) {
            attributes.add(checkBox.getText().substring(3));

            if (searchText.indexOf(separator) == -1) {
                values.add(searchText);
            } else {
                values.add(searchText.substring(0, searchText.indexOf(separator)));
                searchText = searchText.substring(searchText.indexOf(separator) + 2);
            }


        }

    }

    public void addQuerry() {

        addValues(titleCheckBox);
        addValues(authorCheckBox);
        addValues(publicationCheckBox);
        addValues(genreCheckBox);
        addValues(publicationDateCheckBox);

        if (attributes.size() == 0 && !idCheckBox.isSelected())
            return;

        int startValue = 0;

        if (idCheckBox.isSelected()) {
            try {
                startValue = Integer.parseInt(searchText);
            } catch (Exception e) {
            }
        }

        List<Book> l = this.db.getBookGetter().getBook(attributes, values, startValue);

        for (Book b : l) {
            addEntry(b);
        }

        attributes.clear();
        values.clear();

        this.repaint();

    }

    public void clearLastQuerry() {

        nextObjectLocation = 110;

        if (this.getComponentCount() == pozBeforeQuery)
            return;

        for (int i = this.getComponentCount() - 1; i >= pozBeforeQuery; i--) {
            this.remove(i);
        }


        this.repaint();

    }

}
