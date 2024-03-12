package dataAccess;

import java.sql.*;
import java.util.Properties;

public class DatabaseManager {
    private static final String databaseName;
    private static final String user;
    private static final String password;
    private static final String connectionUrl;

    /*
     * Load the database information for the db.properties file.
     * Create the database if it does not exist
     */
    static {
        try {
            try (var propStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/db.properties")) {
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
            createTables();
        } catch (Exception ex) {
            throw new RuntimeException("unable to create database/tables. " + ex.getMessage());
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
    /*
    """
    CREATE TABLE IF NOT EXISTS auth (
        id INT NOT NULL AUTO_INCREMENT,
        username VARCHAR(64) NOT NULL,
        authToken VARCHAR(64) NOT NULL,
        PRIMARY KEY (id),
        INDEX(username),
        INDEX(authToken)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_cs
   CREATE TABLE IF NOT EXISTS game (
        id INT NOT NULL AUTO_INCREMENT,
        gameID INT NOT NULL,
        whiteUsername VARCHAR(64) DEFAULT NULL,
        blackUsername VARCHAR(64) DEFAULT NULL,
        gameName VARCHAR(128) NOT NULL,
        game TEXT DEFAULT NULL,
        PRIMARY KEY (id),
        INDEX(gameID),
        INDEX(gameName)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs
    CREATE TABLE IF NOT EXISTS user (
        id INT NOT NULL AUTO_INCREMENT,
        username VARCHAR(64) NOT NULL,
        password VARCHAR(64) NOT NULL,
        email VARCHAR(64) NOT NULL,
        PRIMARY KEY (id),
        INDEX(username),
        INDEX(password)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_as_cs
    """
    */
    private static final String S0 = "USE " + databaseName;
    private static final String S1 = "CREATE TABLE IF NOT EXISTS auth (id INT NOT NULL AUTO_INCREMENT,username VARCHAR(64) NOT NULL, authToken VARCHAR(64) NOT NULL, PRIMARY KEY (id), INDEX(username), INDEX(authToken) ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci";
    private static final String S2 = "CREATE TABLE IF NOT EXISTS game (id INT NOT NULL AUTO_INCREMENT,gameID INT NOT NULL,whiteUsername VARCHAR(64) DEFAULT NULL,blackUsername VARCHAR(64) DEFAULT NULL,gameName VARCHAR(128) NOT NULL,game TEXT DEFAULT NULL,PRIMARY KEY (id),INDEX(gameID),INDEX(gameName)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci";
    private static final String S3 = "CREATE TABLE IF NOT EXISTS user (id INT NOT NULL AUTO_INCREMENT,username VARCHAR(64) NOT NULL,password VARCHAR(64) NOT NULL,email VARCHAR(64) NOT NULL,PRIMARY KEY (id),INDEX(username),INDEX(password)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci";

    static void createTables() throws DataAccessException {
        String[] s = new String[4];
        s[0] = S0;
        s[1] = S1;
        s[2] = S2;
        s[3] = S3;
        try (var conn = DriverManager.getConnection(connectionUrl, user, password)){
            for (String statement : s) {
                try (var preparedStatement = conn.prepareStatement(statement)) {
                    preparedStatement.executeUpdate();
                }
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
}