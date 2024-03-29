package dataAccess;

import model.AuthData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.sql.ResultSet;

//import dataAccess.DatabaseManager;

public class AuthDAOSQL {
    public static String createAuth(String username) throws DataAccessException{
        String authToken = UUID.randomUUID().toString();

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {

                String statement = "INSERT INTO auth (username, authToken) VALUES (?,?)";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement)) {
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, authToken);
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
        return authToken;
    }
    public static AuthData getAuth(String username) throws DataAccessException{
        AuthData authData = null;

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {
                String statement2 = "SELECT authToken FROM auth WHERE username = ?";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement2)) {
                    preparedStatement.setString(1, username);
                    try(ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            authData = new AuthData(username, resultSet.getString("authToken"));
                        }
                        else {
                            authData = null;
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

        return authData;
    }
    public static AuthData getAuthFromToken(String authToken) throws DataAccessException{
        AuthData authData = null;

        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {

                String statement = "SELECT username FROM auth WHERE authToken = ?";


                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement)) {
                    preparedStatement.setString(1, authToken);
                    try(ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            authData = new AuthData(resultSet.getString("username"), authToken);
                        }
                        else {
                            authData = null;
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

        return authData;
    }
    public static boolean deleteAuth(String authToken) throws DataAccessException{
        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {
                String statement = "DELETE FROM auth WHERE authToken = ?";

                // try creating and running the statement
                try (PreparedStatement preparedStatement = conn.prepareStatement(statement)) {
                    preparedStatement.setString(1, authToken);
                    preparedStatement.executeUpdate();
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
    public static boolean clear() throws DataAccessException{
        // establish connection
        try (Connection conn = DatabaseManager.getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {

                String statement = "DELETE FROM auth";

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
