package Database;

import UsableClasses.Book;

import java.sql.*;

public class BookModifier {

    private final Connection conn;

    public BookModifier(Connection connection) {
        conn = connection;
    }


    // Delete a book from the database
    public boolean deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            int rowsDeleted = pstmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public void addBook(Book book) throws SQLException {
        // retrieve the author, publication, and genre IDs from the database
        int authorId = getIdFromValue("authors", "author", book.getAuthor().toLowerCase());
        int publicationId = getIdFromValue("publications", "publication", book.getPublication().toLowerCase());
        int genreId = getIdFromValue("genres", "genre", book.getGenre().toLowerCase());

        // if the author, publication, or genre does not already exist in the database, insert it
        if (authorId == -1) {
            authorId = insertValue("authors", "author", book.getAuthor().toLowerCase());
        }
        if (publicationId == -1) {
            publicationId = insertValue("publications", "publication", book.getPublication().toLowerCase());
        }
        if (genreId == -1) {
            genreId = insertValue("genres", "genre", book.getGenre().toLowerCase());
        }

        // create the Prepared Statement with an INSERT query
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO books (title, author_id, publication_id," +
                " location, genre_id, publicationDate) VALUES (?, ?, ?, ?, ?, ?)");

        // set the values for the Prepared Statement
        stmt.setString(1, book.getTitle());
        stmt.setInt(2, authorId);
        stmt.setInt(3, publicationId);
        stmt.setString(4, book.getLocation());
        stmt.setInt(5, genreId);
        stmt.setDate(6, book.getPublicationDate());

        // execute the Prepared Statement
        stmt.executeUpdate();
    }

    private int getIdFromValue(String table, String column, String value) throws SQLException {
        // create the Prepared Statement with a SELECT query
        PreparedStatement stmt = conn.prepareStatement("SELECT id FROM " + table + " WHERE " + column + " = ?");

        // set the value for the Prepared Statement
        stmt.setString(1, value);

        // execute the Prepared Statement and retrieve the result set
        ResultSet rs = stmt.executeQuery();

        // retrieve the ID from the result set
        int id = -1;
        if (rs.next()) {
            id = rs.getInt("id");
        }

        return id;
    }

    private int insertValue(String table, String column, String value) throws SQLException {
        // create the Prepared Statement with an INSERT query
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + table + " (" + column + ") VALUES (?)",
                Statement.RETURN_GENERATED_KEYS);

        // set the value for the Prepared Statement
        stmt.setString(1, value);

        // execute the Prepared Statement
        stmt.executeUpdate();

        // retrieve the generated ID
        ResultSet rs = stmt.getGeneratedKeys();
        int id = -1;
        if (rs.next()) {
            id = rs.getInt(1);
        }

        return id;
    }

}