package dataAccess;

import chess.ChessGame;
import model.GameData;

import java.util.*;

public class GameDAOMemory extends GameDAOInterface {
    static List<GameData> list = new ArrayList<>();
    public static int createGame(String gameName) {

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
            if(Objects.equals(game.gameName(), name)) { return true; }
        }
        return false;
    }
    public static GameData getGame(int id) {
        for(GameData game : list) {
            if(game.gameID() == id) { return game; }
        }
        return null;
    }
    public static Collection<GameData> listGames() {
        return list;
    }
    public static boolean updateGame(int id, String whiteUsername, String blackUsername) {
        int index = -1;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).gameID() == id) {
                index = i;
                break;
            }
        }
        if(index == -1) { return false; }
        list.set(index, new GameData(id, whiteUsername, blackUsername, list.get(index).gameName(), list.get(index).game()));
        return true;
    }
    public static boolean clear() {
        list.clear();
        return true;
    }
}
