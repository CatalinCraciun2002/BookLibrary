package Database;

import UsableClasses.Book;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

public class BookTableInitialization {

    public BookTableInitialization(BookModifier bookModifier) throws SQLException {

        Calendar calendar = Calendar.getInstance();

        calendar.set(1925, Calendar.APRIL, 10);
        bookModifier.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald",
                "Charles Scribner's Sons", "Novel", "A12", new Date(calendar.getTimeInMillis())));

        calendar.set(1850, Calendar.JANUARY, 1);
        bookModifier.addBook(new Book(2, "Moby-Dick", "Herman Melville", "Richard Bentley",
                "Novel", "C6", new Date(calendar.getTimeInMillis())));

        calendar.set(1865, Calendar.JUNE, 16);
        bookModifier.addBook(new Book(3, "Alice's Adventures in Wonderland", "Lewis Carroll",
                "Macmillan Publishers", "Fiction", "L18", new Date(calendar.getTimeInMillis())));

        calendar.set(1900, Calendar.NOVEMBER, 1);
        bookModifier.addBook(new Book(4, "The Picture of Dorian Gray", "Oscar Wilde",
                "Ward, Lock, and Co.", "Fiction", "M9", new Date(calendar.getTimeInMillis())));

        calendar.set(1922, Calendar.JULY, 29);
        bookModifier.addBook(new Book(5, "Ulysses", "James Joyce",
                "Shakespeare and Company", "Novel", "B7", new Date(calendar.getTimeInMillis())));

        calendar.set(1939, Calendar.SEPTEMBER, 21);
        bookModifier.addBook(new Book(6, "The Grapes of Wrath", "John Steinbeck",
                "Viking Press", "Novel", "D1", new Date(calendar.getTimeInMillis())));

        calendar.set(1952, Calendar.OCTOBER, 15);
        bookModifier.addBook(new Book(7, "Invisible Man", "Ralph Ellison",
                "Random House", "Novel", "R10", new Date(calendar.getTimeInMillis())));

        calendar.set(1937, Calendar.JULY, 11);
        bookModifier.addBook(new Book(8, "The Catcher in the Rye", "J.D. Salinger",
                "Little, Brown and Company", "Novel", "M3", new Date(calendar.getTimeInMillis())));

        calendar.set(1952, Calendar.SEPTEMBER, 17);
        bookModifier.addBook(new Book(9, "The Old Man and the Sea", "Ernest Hemingway",
                "Charles Scribner's Sons", "Novel", "M4", new Date(calendar.getTimeInMillis())));

        calendar.set(1954, Calendar.SEPTEMBER, 10);
        bookModifier.addBook(new Book(10, "A Clockwork Orange", "Anthony Burgess",
                "Heinemann", "Novel", "M9", new Date(calendar.getTimeInMillis())));

        calendar.set(1959, Calendar.JULY, 16);
        bookModifier.addBook(new Book(11, "To Kill a Mockingbird", "Harper Lee",
                "J.B. Lippincott & Co.", "Novel", "A2", new Date(calendar.getTimeInMillis())));

        calendar.set(1947, Calendar.JANUARY, 1);
        bookModifier.addBook(new Book(12, "Animal Farm", "George Orwell",
                "Secker and Warburg", "Political fiction", "F10", new Date(calendar.getTimeInMillis())));

        calendar.set(1961, Calendar.APRIL, 25);
        bookModifier.addBook(new Book(13, "One Hundred Years of Solitude",
                "Gabriel García Márquez", "Editorial Sudamericana", "Magical realism", "L1", new Date(calendar.getTimeInMillis())));

        calendar.set(1952, Calendar.JULY, 15);
        bookModifier.addBook(new Book(14, "Invisible Man", "Ralph Ellison",
                "Random House", "Novel", "C3", new Date(calendar.getTimeInMillis())));

        calendar.set(1959, Calendar.OCTOBER, 5);
        bookModifier.addBook(new Book(15, "To Kill a Mockingbird", "Harper Lee",
                "J. B. Lippincott & Co.", "Novel", "B7", new Date(calendar.getTimeInMillis())));

        calendar.set(1938, Calendar.JUNE, 8);
        bookModifier.addBook(new Book(16, "Rebecca", "Daphne du Maurier",
                "Victor Gollancz Ltd", "Gothic fiction", "H3", new Date(calendar.getTimeInMillis())));


    }
}
