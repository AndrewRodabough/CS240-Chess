package service;

import dataAccess.AuthDAOMemory;
import dataAccess.GameDAOMemory;
import model.AuthData;
import model.GameData;

import java.util.Objects;

public class JoinGame{
    public static boolean Run(String authToken, String playerColor, int gameID) {
        GameData game = GameDAOMemory.getGame(gameID);
        if (game == null) { return false; }

        AuthData auth = AuthDAOMemory.getAuthFromToken(authToken);

        if (Objects.equals(playerColor, "WHITE")) {
            if(game.whiteUsername() == null) {
                GameDAOMemory.updateGame(gameID, auth.username(), game.blackUsername());
            }
            else {
                return false;
            }
        }
        else if (Objects.equals(playerColor, "BLACK")) {
            if(game.blackUsername() == null) {
                GameDAOMemory.updateGame(gameID, game.whiteUsername(), auth.username());
            }
            else {
                return false;
            }
        }
        else {
            return true;
        }
        return true;
    }
}
