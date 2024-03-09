package dataAccess;

import java.sql.*;
import java.util.Properties;

public class DatabaseManager {
    private static final String databaseName;
    private static final String user;
    private static final String password;
    private static final String connectionUrl;
    public static final InsertTemplate

    /*
     * Load the database information for the db.properties file.
     * Create the database if it does not exist
     */
    static {
        try {
            try (var propStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties")) {
                if (propStream == null) throw new Exception("Unable to laod db.properties");
                Properties props = new Properties();
                props.load(propStream);
                databaseName = props.getProperty("db.name");
                user = props.getProperty("db.user");
                password = props.getProperty("db.password");

                var host = props.getProperty("db.host");
                var port = Integer.parseInt(props.getProperty("db.port"));
                connectionUrl = String.format("jdbc:mysql://%s:%d", host, port);
            }
        } catch (Exception ex) {
            throw new RuntimeException("unable to process db.properties. " + ex.getMessage());
        }

        try {
            createDatabase();
        } catch (Exception ex) {
            throw new RuntimeException("unable to create database" + ex.getMessage());
        }
    }

    /**
     * Creates the database if it does not already exist.
     */
    static void createDatabase() throws DataAccessException {
        try {
            var statement = "CREATE DATABASE IF NOT EXISTS " + databaseName;
            var conn = DriverManager.getConnection(connectionUrl, user, password);
            try (var preparedStatement = conn.prepareStatement(statement)) {
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    /**
     * Create a connection to the database and sets the catalog based upon the
     * properties specified in db.properties. Connections to the database should
     * be short-lived, and you must close the connection when you are done with it.
     * The easiest way to do that is with a try-with-resource block.
     * <br/>
     * <code>
     * try (var conn = DbInfo.getConnection(databaseName)) {
     * // execute SQL statements.
     * }
     * </code>
     */
    static Connection getConnection() throws DataAccessException {
        try {
            var conn = DriverManager.getConnection(connectionUrl, user, password);
            conn.setCatalog(databaseName);
            return conn;
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
    }

    static void RunStatements(String[] statements, String[][] values) throws DataAccessException {

        // establish connection
        try (Connection conn = getConnection()) {
            //connection established

            //do not autocommit to db
            conn.setAutoCommit(false);

            //run statements
            try {

                // loop through operations to complete
                for(int i=0; i<statements.length; i++) {

                    // try creating and running the statement
                    try (PreparedStatement preparedStatement = conn.prepareStatement(statements[i])) {
                        for(int j=1; j<values[i].length + 1; j++) {
                            preparedStatement.setString(j, values[i][j]);
                        }
                        preparedStatement.executeUpdate();
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
    }
}