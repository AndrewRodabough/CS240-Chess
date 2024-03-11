package service;

import dataAccess.AuthDAOSQL;
import dataAccess.GameDAOSQL;
import model.AuthData;
import model.GameData;

import java.util.Objects;

public class JoinGame{
    public static boolean Run(String authToken, String playerColor, int gameID) {
        try {

            GameData game = GameDAOSQL.getGame(gameID);
            if (game == null) {
                return false;
            }

            AuthData auth = null;
            try {
                auth = AuthDAOSQL.getAuthFromToken(authToken);
            } catch (Exception e) {
                return false;
            }

            if (Objects.equals(playerColor, "WHITE")) {
                if (game.whiteUsername() == null) {
                    GameDAOSQL.updateGameUser(gameID, auth.username(), game.blackUsername());
                } else {
                    return false;
                }
            } else if (Objects.equals(playerColor, "BLACK")) {
                if (game.blackUsername() == null) {
                    GameDAOSQL.updateGameUser(gameID, game.whiteUsername(), auth.username());
                } else {
                    return false;
                }
            } else {
                return true;
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
