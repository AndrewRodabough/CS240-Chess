package dataAccess;
import model.AuthData;
import model.UserData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserDAOSQL {
    public static boolean createUser(UserData user) throws DataAccessException{

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {

                String statement = "INSERT INTO user (username, password, email) VALUES (?,?,?)";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement)) {
                    preparedStatement.setString(1, user.username());
                    preparedStatement.setString(2, user.password());
                    preparedStatement.setString(3, user.email());
                    preparedStatement.execute();
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }
        return true;
    }
    public static UserData getUser(String username) throws DataAccessException, SQLException {
        UserData user = null;

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {
                String statement2 = "SELECT * FROM user WHERE username = ?";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement2)) {
                    preparedStatement.setString(1, username);
                    try(ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            user = new UserData(resultSet.getString("username"),
                                    resultSet.getString("password"),
                                    resultSet.getString("email"));
                        }
                    }
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }

        return user;
    }
    public static boolean clear() throws DataAccessException, SQLException {
        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {

                String statement = "DELETE FROM user";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement)) {
                    preparedStatement.execute();
                }

                // success commit all operations of transaction
                conn.commit();

            } catch (Exception e) {
                // transaction failed
                conn.rollback();
                throw new DataAccessException("Unable to complete transaction" + e.getMessage());
            } finally {
                // re-engage autocommit
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            // connection not established
            throw new DataAccessException(e.getMessage());
        }
        return true;
    }
}
