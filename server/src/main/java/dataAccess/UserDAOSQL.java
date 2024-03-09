package dataAccess;
import model.UserData;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAOSQL {
    static boolean createUser(UserData user) throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false);
            try {
                // SQL statements in transaction
                String insertSql = "INSERT INTO your_table (column1, column2) VALUES (?, ?)";
                insertData(connection);
                updateData(connection);
                deleteData(connection);

                // Commit the transaction if all operations succeed
                conn.commit();

            } catch (SQLException e) {
                // Rollback the transaction
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction");
            } finally {
                // Enable auto-commit to return to the default behavior
                conn.setAutoCommit(true);
            }
        }
        return false;
    }
    static UserData getUser(String username) throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return null;
    }
    public static boolean clear() throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return true;
    }
}
