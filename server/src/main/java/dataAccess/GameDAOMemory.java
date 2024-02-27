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
            // generate a unique 6 digit number from 100000-999999 for id
            num = 100000 + random.nextInt(900000);
        } while (idExists(num));

        //create game in database
        list.add(new GameData(num, null, null, gameName, new ChessGame()));
        return num;
    }
    public static boolean idExists(int id) {
        // loops through all games and checks for matching id
        for(GameData game : list) {
            if(game.gameID() == id) { return true; }
        }
        return false; // id does not exist
    }
    public static boolean nameExists(String name) {
        // loops through all games and checks for matching name
        for(GameData game : list) {
            if(Objects.equals(game.gameName(), name)) { return true; }
        }
        return false; // name does not exist
    }
    public static GameData getGame(int id) {
        // loops through all games and checks for matching id
        for(GameData game : list) {
            if(game.gameID() == id) { return game; }
        }
        return null; // game does not exist
    }
    public static Collection<GameData> listGames() {
        return list;
    }
    public static int getIndexOfGame(int id) {
        // returns index of game on the list
        int index = -1;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).gameID() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
    public static boolean updateGameUser(int id, String whiteUsername, String blackUsername) {

        int index = getIndexOfGame(id);
        if(index == -1) { return false; }

        // create new record with updated user data
        list.set(index, new GameData(id, whiteUsername, blackUsername, list.get(index).gameName(), list.get(index).game()));
        return true;
    }
    public static boolean clear() {
        list.clear();
        return true;
    }
}
