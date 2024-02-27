package dataAccess;

import chess.ChessGame;
import model.GameData;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Random;

abstract class GameDAOInterface implements DAOInterface{
    static boolean CreateGame(String gameName) { return false; }
    static boolean idExists(int id) { return false; }
    static boolean nameExists(String name) { return false; }
    static ChessGame GetGame(int id) { return null; }
    static Collection<GameData> ListGames() { return null; }
    static boolean UpdateGame(int id) {return false; }
    public static boolean Clear() {
        return true;
    }
}
