package service;

import chess.ChessGame;
import dataAccess.AuthDAOMemory;
import dataAccess.GameDAOMemory;
import model.AuthData;
import model.GameData;

import java.util.Objects;

public class JoinGame{
    public static boolean Run(String authToken, String playerColor, int gameID) {
        GameData game = GameDAOMemory.GetGame(gameID);
        if (game == null) { return false; }

        AuthData auth = AuthDAOMemory.GetAuthFromToken(authToken);

        if (Objects.equals(playerColor, "WHITE")) {
            if(game.whiteUsername() == null) {
                GameDAOMemory.UpdateGame(gameID, auth.username(), game.blackUsername());
            }
            else {
                return false;
            }
        }
        else if (Objects.equals(playerColor, "BLACK")) {
            if(game.blackUsername() == null) {
                GameDAOMemory.UpdateGame(gameID, game.whiteUsername(), auth.username());
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
