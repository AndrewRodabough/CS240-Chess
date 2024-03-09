package dataAccess;

import model.AuthData;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthDAOSQL {
    static boolean createAuth(String username) throws DataAccessException{
        String AuthToken = UUID.randomUUID().toString();
        String[] statements =
        List<String> statements = new ArrayList<>();
        List<List<String>> param = new ArrayList<>();
        DatabaseManager.RunStatements();
        return false;
    }
    static AuthData getAuth(String username) throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return null;
    }
    static AuthData getAuthFromToken(String authToken) throws DataAccessException, SQLException{
        try (var conn = DatabaseManager.getConnection()) {

        }
        return null;
    }
    static boolean deleteAuth(AuthData auth) throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return false;
    }
    static boolean clear() throws DataAccessException, SQLException{
        try (var conn = DatabaseManager.getConnection()) {

        }
        return false;
    }
}
