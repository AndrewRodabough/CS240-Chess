package ClientStateMachine.States.LoggedIn;

import ClientStateMachine.ServerFacade;
import ClientStateMachine.StateMachine;
import ClientStateMachine.States.State;
import chess.ChessGame;
import com.google.gson.Gson;
import model.GameData;

import java.net.http.HttpResponse;
import java.util.Collection;

public class InGame extends State {
    @Override
    public String getSignature() { return "playing"; }
    @Override
    public int getNumArgs() { return 0; }

    @Override
    public State Run(StateMachine sm) {
        Boolean correctArgs = checkArgs(sm);
        if (!correctArgs) {
            sm.setArgs(null);
            return new Menu();
        }

        HttpResponse<String> res = ServerFacade.sendRequest("/game", "GET", "", sm.createAuthHeader());

        Boolean goodRes = checkStatus(res);
        if(!goodRes) {
            sm.setArgs(null);
            return new ClientStateMachine.States.LoggedOut.Menu();
        }

        Collection<GameData> games = new Gson().fromJson(res.body(), handler.ListGames.games.class).games();
        GameData yourGame = null;
        for(GameData game : games) {
            if(game.gameID() == sm.getGameID()) {
                yourGame = game;
                break;
            }
        }

        yourGame.game().initializeGame();
        printBoard(yourGame.game().getBoard().getSquares());
        System.out.println();
        printBoardFlip(yourGame.game().getBoard().getSquares());

        System.out.println("Implement In Game\n");
        sm.setArgs(null);
        return null;
    }

    public static void printBoard(chess.ChessPiece[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String piece = getPieceSymbol(board[i][j]);
                String color = ((i + j) % 2 == 0) ? "\u001B[47m" : "\u001B[40m"; // White or black square
                System.out.print(color + piece + " ");
            }
            System.out.println("\u001B[0m"); // Reset color
        }
    }
    public static void printBoardFlip(chess.ChessPiece[][] board) {
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = board[i].length - 1; j >= 0 ; j--) {
                String piece = getPieceSymbol(board[i][j]);
                String color = ((i + j) % 2 == 0) ? "\u001B[47m" : "\u001B[40m"; // White or black square
                System.out.print(color + piece + " ");
            }
            System.out.println("\u001B[0m"); // Reset color
        }
    }

    public static String getPieceSymbol(chess.ChessPiece piece) {
        if(piece == null) {
            return " \u2003";
        }
        String val = "";
        if(piece.getTeamColor() == ChessGame.TeamColor.WHITE) {
            val += "\u001B[38;5;12m";
        }
        else {
            val += "\u001B[38;5;160m";
        }
        switch (piece.getPieceType()) {
            case PAWN: return val +" ♙"; // Pawn
            case KNIGHT: return val +" ♘"; // Knight
            case BISHOP: return val +" ♗"; // Bishop
            case ROOK: return val +" ♖"; // Rook
            case KING: return val +" ♔"; // King
            case QUEEN: return val +" ♕"; // Queen
            default: return val +"  ";
        }
    }
}
