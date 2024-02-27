package dataAccess;

import model.GameData;

import java.util.Collection;

abstract class GameDAOInterface implements DAOInterface{
    static int createGame(String gameName) { return -1; }
    static boolean idExists(int id) { return false; }
    static boolean nameExists(String name) { return false; }
    static GameData getGame(int id) { return null; }
    static Collection<GameData> listGames() { return null; }
    static boolean updateGame(int id, String whiteUsername, String blackUsername) {return false; }
    public static boolean clear() {
        return true;
    }
}
