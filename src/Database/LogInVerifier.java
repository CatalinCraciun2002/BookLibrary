package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInVerifier {

    String firstName = "";
    String lastName = "";
    private Connection conn;

    public LogInVerifier(java.sql.Connection connection) {
        conn = connection;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int checkCredentials(String username, String password) throws SQLException {
        // Create a Prepared Statement object using the Connection.prepare Statement method
        PreparedStatement stmt = conn.prepareStatement("SELECT first_name, last_name, user_rights FROM persons WHERE username = ? AND password = ?");

        // Set the values for the placeholders using the Prepared Statement.set String method

        stmt.setString(1, username);
        stmt.setString(2, password);

        // Execute the SELECT statement using the Prepared Statement.execute Query method and store the result in a ResultSet object
        ResultSet rs = stmt.executeQuery();

        // Check if there is a matching row in the ResultSet using the ResultSet.next method
        if (rs.next()) {

            // Stores first and last name in the class variables for their eventual retrieval
            firstName = rs.getString("first_name");

            lastName = rs.getString("last_name");

            // If there is a matching row, return the user_rights value using the ResultSet.get Int method
            return rs.getInt("user_rights");
        } else {
            // If there is no matching row, return -1
            return -1;
        }
    }


}
