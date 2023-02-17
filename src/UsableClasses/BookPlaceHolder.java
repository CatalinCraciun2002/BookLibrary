package UsableClasses;

import GUI.RemoveButton;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;

public class BookPlaceHolder {


    private final int id = 0;

    public JTextField title, author, publication;
    public JTextField genre, location, publicationDate;

    private final RemoveButton removeButton = new RemoveButton();

    public BookPlaceHolder() {

        title = new JTextField();
        author = new JTextField();
        publication = new JTextField();
        genre = new JTextField();
        location = new JTextField();
        publicationDate = new JTextField();

    }

    public RemoveButton getRemoveButton() {
        return removeButton;
    }

    public JTextField getTitle() {
        return title;
    }

    public JTextField getAuthor() {
        return author;
    }

    public JTextField getPublication() {
        return publication;
    }

    public JTextField getGenre() {
        return genre;
    }

    public JTextField getLocation() {
        return location;
    }

    public JTextField getPublicationDate() {
        return publicationDate;
    }

    public boolean isConvertable() {

        String title = this.getTitle().getText();
        String author = this.getAuthor().getText();
        String publication = this.getPublication().getText();
        String genre = this.getGenre().getText();
        String location = this.getLocation().getText();
        String dateString = this.getPublicationDate().getText();

        if (title.equals("") || author.equals("") || publication.equals("") || genre.equals("") || location.equals("") ||
                dateString.equals(""))
            return false;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.parse(dateString);

        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    public Book convertToBook() throws ParseException {

        String title = this.getTitle().getText();
        String author = this.getAuthor().getText();
        String publication = this.getPublication().getText();
        String genre = this.getGenre().getText();
        String location = this.getLocation().getText();
        String dateString = this.getPublicationDate().getText();


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate = dateFormat.parse(dateString);
        java.sql.Date sqlDate = java.sql.Date.valueOf(parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());


        return new Book(0, title, author, publication, genre, location, sqlDate);

    }


}
