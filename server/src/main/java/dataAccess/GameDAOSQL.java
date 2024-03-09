package dataAccess;

import model.GameData;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class GameDAOSQL {
    static int createGame(String gameName) throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return -1;
    }
    static boolean idExists(int id) throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return false;
    }
    static boolean nameExists(String name) throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return false;
    }
    static GameData getGame(int id) throws DataAccessException, SQLException{
        try (var conn = DatabaseManager.getConnection()) {

        }
        return null;
    }
    static Collection<GameData> listGames() throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return null;
    }
    static boolean updateGameUser(int id, String whiteUsername, String blackUsername) throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return false;
    }
    public static boolean clear() throws DataAccessException, SQLException {
        try (var conn = DatabaseManager.getConnection()) {

        }
        return true;
    }
}
