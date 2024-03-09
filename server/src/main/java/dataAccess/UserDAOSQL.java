package dataAccess;
import model.UserData;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAOSQL {
    static boolean createUser(UserData user) throws DataAccessException{

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
