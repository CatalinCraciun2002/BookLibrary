package GUI;

import Database.LibraryDatabase;
import UsableClasses.Book;
import UsableClasses.BookPlaceHolder;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddBookGUI extends JPanel implements AddingInterface<BookPlaceHolder> {


    private int nextObjectLocation = 60;
    final int startSecondCollumn = 140;

    List<BookPlaceHolder> list = new ArrayList<BookPlaceHolder>();


    LibraryDatabase db;
    int pozBeforeQuerry = -1;

    @Override
    public void addEntry(BookPlaceHolder entry) {


        int titlePoz = this.startSecondCollumn;
        int titleWidth = 170;
        entry.getTitle().setSize(titleWidth, 40);
        entry.getTitle().setLocation(titlePoz, nextObjectLocation);

        int authorPoz = titlePoz + titleWidth + 20;
        int authorWidth = 130;
        entry.getAuthor().setSize(authorWidth, 40);
        entry.getAuthor().setLocation(authorPoz, nextObjectLocation);

        int publicationPoz = authorPoz + authorWidth + 20;
        int publicationWidth = 130;
        entry.getPublication().setSize(publicationWidth, 40);
        entry.getPublication().setLocation(publicationPoz, nextObjectLocation);

        int genrePoz = publicationPoz + publicationWidth + 20;
        int genreWidth = 140;
        entry.getGenre().setSize(genreWidth, 40);
        entry.getGenre().setLocation(genrePoz, nextObjectLocation);

        int locationPoz = genrePoz + genreWidth + 20;
        int locationWidth = 70;
        entry.getLocation().setSize(locationWidth, 40);
        entry.getLocation().setLocation(locationPoz, nextObjectLocation);

        int datePoz = locationPoz + locationWidth + 20;
        int dateWidth = 80;
        entry.getPublicationDate().setSize(dateWidth, 40);
        entry.getPublicationDate().setLocation(datePoz, nextObjectLocation);


        entry.getRemoveButton().setStartIndex(this.getComponentCount());

        //this.add(entry.getRemoveButton());
        this.add(entry.getTitle());
        this.add(entry.getAuthor());
        this.add(entry.getPublication());
        this.add(entry.getGenre());
        this.add(entry.getLocation());
        this.add(entry.getPublicationDate());

        entry.getRemoveButton().setEndIndex(this.getComponentCount());

        entry.getRemoveButton().setLocation(startSecondCollumn - 60, nextObjectLocation);
        entry.getRemoveButton().setSize(50, 40);
        entry.getRemoveButton().setText("X");
        entry.getRemoveButton().addActionListener(e -> {
            for (int i = entry.getRemoveButton().getEndIndex() - 1; i >= entry.getRemoveButton().getStartIndex(); i--) {
                this.remove(i);
            }

            this.repaint();

        });


        nextObjectLocation += 50;
        list.add(entry);

    }

    @Override
    public void addQuerry() {

        int counter = 0;

        while (list.size() > 0) {

            BookPlaceHolder b = list.get(0);
            counter++;
            try {
                if (b.isConvertable()) {

                    Book convertedBook = b.convertToBook();
                    db.getBookModifier().addBook(convertedBook);
                    succesfullList += " " + String.valueOf(counter);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Parse error");
            } finally {
                list.remove(0);
            }

        }

    }

    @Override
    public void clearLastQuerry() {

        nextObjectLocation = 110;

        if (this.getComponentCount() == pozBeforeQuerry)
            return;

        for (int i = this.getComponentCount() - 1; i >= pozBeforeQuerry; i--) {
            this.remove(i);
        }

        this.repaint();

        pozBeforeQuerry = this.getComponentCount();


    }

    private void addLabels() {


        int titlePoz = this.startSecondCollumn + 70;
        JLabel titleLable = new JLabel();
        titleLable.setText("Title");
        int titleWidth = 120;
        titleLable.setSize(titleWidth, 40);
        titleLable.setLocation(titlePoz, nextObjectLocation);

        int authorPoz = titlePoz + titleWidth + 50;
        JLabel authorLable = new JLabel();
        int authorWidth = 100;
        authorLable.setText("Author");
        authorLable.setSize(authorWidth, 40);
        authorLable.setLocation(authorPoz, nextObjectLocation);

        int publicationPoz = authorPoz + authorWidth + 30;
        JLabel publicationLable = new JLabel();
        int publicationWidth = 120;
        publicationLable.setText("Publication");
        publicationLable.setSize(publicationWidth, 40);
        publicationLable.setLocation(publicationPoz, nextObjectLocation);

        int genrePoz = publicationPoz + publicationWidth + 50;
        JLabel genreLable = new JLabel();
        int genreWidth = 90;
        genreLable.setText("Genre");
        genreLable.setSize(genreWidth, 40);
        genreLable.setLocation(genrePoz, nextObjectLocation);

        int locationPoz = genrePoz + genreWidth + 25;
        JLabel locationLable = new JLabel();
        int locationWidth = 70;
        locationLable.setText("Location");
        locationLable.setSize(locationWidth, 40);
        locationLable.setLocation(locationPoz, nextObjectLocation);


        int datePoz = locationPoz + locationWidth + 5;
        JLabel dateLable = new JLabel();
        int dateWidth = 120;
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

    private void addComponents() {
        this.setLayout(null);
        this.add(submitButton);
        this.add(newButton);

        addLabels();

        pozBeforeQuerry = this.getComponentCount();

    }

    private JButton newButton = new JButton();
    private JButton submitButton = new JButton();

    private String succesfullList = "";


    public AddBookGUI(LibraryDatabase database) {

        super();
        this.db = database;


        submitButton.setSize(250, 30);
        submitButton.setLocation(startSecondCollumn + 300, 20);
        submitButton.setText("Submit");
        submitButton.addActionListener(e -> {

            addQuerry();
            clearLastQuerry();
            ErrorWindow.showSubmitSuccessfulDialog("The following entries were successfully added to the database:" +
                    succesfullList);

            succesfullList = "";
        });

        newButton.setSize(110, 30);
        newButton.setLocation(10, 20);
        newButton.setText("New");
        newButton.addActionListener(e -> {

            if (list.size() <= 7) {
                addEntry(new BookPlaceHolder());
                this.repaint();
            }


        });

        this.setBackground(Color.lightGray);

        addComponents();


    }

}
