package UsableClasses;

import java.sql.Date;

public class Book {

    private final int id;
    private final String title;
    private final String author;
    private final String publication;
    private final String genre;
    private final String location;
    private final Date publicationDate;

    public Book(int id, String title, String author, String publication, String genre, String location, Date publicationDate) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.genre = genre;
        this.location = location;
        this.publicationDate = publicationDate;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public String getGenre() {
        return genre;
    }

    public String getLocation() {
        return location;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void displayBook() {

        System.out.println("Id: " + this.getId());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("Publication: " + this.getPublication());
        System.out.println("Location: " + this.getLocation());
        System.out.println("Genre: " + this.getGenre());
        System.out.println("Publication Date: " + this.getPublicationDate());

    }

}
