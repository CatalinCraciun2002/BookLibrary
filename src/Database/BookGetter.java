package Database;

import UsableClasses.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookGetter {

    private final Connection conn;

    public BookGetter(Connection connection) {
        this.conn = connection;
    }

    // Search for books in the database
    private ResultSet searchDB(ArrayList<String> attributes, ArrayList<String> values) throws SQLException {
        // Build the SQL query
        StringBuilder query = new StringBuilder("SELECT b.id, b.title, a.author, p.publication, b.location, g.genre, b.publicationDate ")
                .append("FROM books b ")
                .append("LEFT JOIN authors a ON b.author_id = a.id ")
                .append("LEFT JOIN publications p ON b.publication_id = p.id ")
                .append("LEFT JOIN genres g ON b.genre_id = g.id ");

        if (attributes.size() > 0)
            query.append("WHERE ");

        for (int i = 0; i < attributes.size(); i++) {

            if (Objects.equals(attributes.get(i), "id")) {

                query.append("b.");
                query.append(attributes.get(i).toLowerCase());
                query.append(" = ");
                query.append("'");
                query.append(values.get(i).toLowerCase());
                query.append("'");

            } else {

                query.append(attributes.get(i).toLowerCase());
                query.append(" LIKE ");
                query.append("'%");
                query.append(values.get(i).toLowerCase());
                query.append("%'");

            }

            if (i < attributes.size() - 1) {
                query.append(" OR ");
            }

        }
        System.out.println("The querry is " + query);
        // Execute the query and return the result set
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query.toString());
    }


    public List<Book> getBook(ArrayList<String> attributes, ArrayList<String> values, int startValue) {

        List<Book> l = new ArrayList<>();

        int counter = 0;

        try {
            ResultSet result = searchDB(attributes, values);


            while (result.next()) {

                if (attributes.size() == 0) {

                    counter++;

                    if (counter < startValue)
                        continue;

                    if (counter > 8 + startValue)
                        break;
                }

                int id = result.getInt(1);
                String title = result.getString(2);
                String author = result.getString(3);
                String publication = result.getString(4);
                String genre = result.getString(6);
                String location = result.getString(5);
                Date publicationDate = result.getDate(7);

                Book current = new Book(id, title, author, publication, genre, location, publicationDate);

                l.add(current);

            }
        } catch (Exception e) {
            System.out.println(e);
        }


        return l;

    }


}
