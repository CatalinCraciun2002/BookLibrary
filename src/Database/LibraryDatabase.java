package Database;

import UsableClasses.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LibraryDatabase {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Database connection
    private Connection conn;
    private TablesSetter tablesSetter;
    private BookGetter bookGetter;
    private BookModifier bookModifier;
    private LogInVerifier logInVerifier;

    public LibraryDatabase() {

        try {

            System.out.println("Started");

            Class driver_class = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver);

            System.out.println("Driver ready");

            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connection established");

            tablesSetter = new TablesSetter(conn.createStatement());
            bookGetter = new BookGetter(conn);
            bookModifier = new BookModifier(conn);
            logInVerifier = new LogInVerifier(conn);

            System.out.println("Connection passed");

            // To reset the tables uncomment this code bellow

            //tablesSetter.tableReset();
            //System.out.println("Tables created");

            //To reenter the accounts in the database uncomment the code bellow

            //insertPersons();
            //System.out.println("Accounts registered");

            // Testing the functionality of the methods
            // testMethods();

            // To populate the tables uncomment the bellow code

            // new BookTableInitialization(bookModifier);
            //System.out.println("Table initialization done");


        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public BookGetter getBookGetter() {
        return bookGetter;
    }

    public BookModifier getBookModifier() {
        return bookModifier;
    }

    private void insertPersons() throws SQLException {

        PreparedStatement stmt = conn.prepareStatement("INSERT INTO persons (user_rights, username, first_name, last_name, password) VALUES (?, ?, ?, ?, ?)");

        // Set the values for the placeholders using the Prepared Statement.set Xxx methods
        stmt.setInt(1, 2);
        stmt.setString(2, "admin");
        stmt.setString(3, "John");
        stmt.setString(4, "Doe");
        stmt.setString(5, "password");

        // Execute the INSERT statement using the Prepared Statement.execute Update method
        stmt.executeUpdate();

        // Set the values for the placeholders using the Prepared Statement.set Xxx methods
        stmt.setInt(1, 1);
        stmt.setString(2, "staff");
        stmt.setString(3, "Jane");
        stmt.setString(4, "Doe");
        stmt.setString(5, "password");

        // Execute the INSERT statement using the Prepared Statement.execute Update method
        stmt.executeUpdate();

        // Set the values for the placeholders using the Prepared Statement.set Xxx methods
        stmt.setInt(1, 0);
        stmt.setString(2, "member");
        stmt.setString(3, "James");
        stmt.setString(4, "Doe");
        stmt.setString(5, "password");

        // Execute the INSERT statement using the Prepared Statement.execute Update method
        stmt.executeUpdate();

    }

    public String getLastName() {
        return logInVerifier.getLastName();
    }

    public String getFirstName() {
        return logInVerifier.getFirstName();
    }

    public int checkCredentials(String username, String password) {

        try {
            return logInVerifier.checkCredentials(username, password);
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    private void testMethods() throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1892, Calendar.DECEMBER, 31);
        Date date = new Date(calendar.getTimeInMillis());

        bookModifier.addBook(new Book(3, "Amintir din copilarie", "Ion Creanga", "junimea", "Short story", "M12", date));


        System.out.println("Test entry loaded");

        ArrayList<String> attributes = new ArrayList<String>();
        ArrayList<String> values = new ArrayList<String>();

        attributes.add("author");
        values.add("Ion Creanga");

        List<Book> l = bookGetter.getBook(attributes, values, 0);

        l.get(0).displayBook();
    }

}

