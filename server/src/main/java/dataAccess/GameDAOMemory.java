package dataAccess;

import chess.ChessGame;
import model.GameData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class GameDAOMemory extends GameDAOInterface {
    static List<GameData> list = new ArrayList<>();
    public static int CreateGame(String gameName) {

        if(nameExists(gameName)) {return -1; }

        Random random = new Random();
        int num;
        do {
            num = 100000 + random.nextInt(900000);
        } while (idExists(num));

        list.add(new GameData(num, null, null, gameName, new ChessGame()));
        return num;
    }
    public static boolean idExists(int id) {
        for(GameData game : list) {
            if(game.gameID() == id) { return true; }
        }
        return false;
    }
    public static boolean nameExists(String name) {
        for(GameData game : list) {
            if(game.gameName() == name) { return true; }
        }
        return false;
    }
    public static ChessGame GetGame(int id) {
        for(GameData game : list) {
            if(game.gameID() == id) { return game.game(); }
        }
        return null;
    }
    public static Collection<GameData> ListGames() {
        return list;
    }
    public static void UpdateGame() {

    }
    public static boolean Clear() {
        return true;
    }
}
