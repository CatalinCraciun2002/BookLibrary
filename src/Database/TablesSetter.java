package Database;

import java.sql.SQLException;
import java.sql.Statement;

public class TablesSetter {

    Statement stmt;

    public TablesSetter(Statement statement) throws SQLException {
        stmt = statement;
    }

    public void tableReset() throws SQLException {


        StringBuilder query_remove, query_create;

        query_remove = new StringBuilder("DROP TABLE IF EXISTS books CASCADE;");
        stmt.executeUpdate(query_remove.toString());

        query_remove = new StringBuilder("DROP TABLE IF EXISTS authors CASCADE;");
        stmt.executeUpdate(query_remove.toString());

        query_remove = new StringBuilder("DROP TABLE IF EXISTS publications CASCADE;");
        stmt.executeUpdate(query_remove.toString());

        query_remove = new StringBuilder("DROP TABLE IF EXISTS genres CASCADE;");
        stmt.executeUpdate(query_remove.toString());


        query_remove = new StringBuilder("DROP TABLE IF EXISTS reservations CASCADE;");
        stmt.executeUpdate(query_remove.toString());

        query_remove = new StringBuilder("DROP TABLE IF EXISTS persons CASCADE;");
        stmt.executeUpdate(query_remove.toString());


        System.out.println("Tables removed");


        query_create = new StringBuilder("CREATE TABLE IF NOT EXISTS authors(" +
                "  id INT NOT NULL AUTO_INCREMENT," +
                "  author VARCHAR(255) NOT NULL," +
                "  PRIMARY KEY (id) ); ");


        stmt.executeUpdate(query_create.toString());
        System.out.println("Table authors created");


        query_create = new StringBuilder("CREATE TABLE IF NOT EXISTS publications (" +
                "  id INT NOT NULL AUTO_INCREMENT," +
                "  publication VARCHAR(255) NOT NULL," +
                "  PRIMARY KEY (id) ); ");


        stmt.executeUpdate(query_create.toString());
        System.out.println("Table publications created");


        query_create = new StringBuilder("CREATE TABLE IF NOT EXISTS genres (" +
                "  id INT NOT NULL AUTO_INCREMENT," +
                "  genre VARCHAR(255) NOT NULL," +
                "  PRIMARY KEY (id) ); ");


        stmt.executeUpdate(query_create.toString());
        System.out.println("Table genres created");


        query_create = new StringBuilder("CREATE TABLE IF NOT EXISTS books (" +
                "  id INT NOT NULL AUTO_INCREMENT," +
                "  title VARCHAR(255) NOT NULL," +
                "  author_id INT NOT NULL," +
                "  publication_id INT," +
                "  genre_id INT NOT NULL," +
                "  location VARCHAR(255) NOT NULL," +
                "  publicationDate DATETIME NOT NULL," +
                "  PRIMARY KEY (id), " +
                "  FOREIGN KEY (author_id) REFERENCES authors(id)," +
                "  FOREIGN KEY (genre_id) REFERENCES genres(id)," +
                "  FOREIGN KEY (publication_id) REFERENCES publications(id) );");

        stmt.executeUpdate(query_create.toString());
        System.out.println("Table books created");


        query_create = new StringBuilder("CREATE TABLE IF NOT EXISTS persons (" +
                "  id INT NOT NULL AUTO_INCREMENT, " +
                "  user_rights INT NOT NULL, " +
                "  username VARCHAR(255) NOT NULL, " +
                "  first_name VARCHAR(255) NOT NULL, " +
                "  last_name VARCHAR(255) NOT NULL, " +
                "  password VARCHAR(255) NOT NULL, " +
                "  PRIMARY KEY (id) );");

        stmt.executeUpdate(query_create.toString());
        System.out.println("Table persons created");


    }


}
