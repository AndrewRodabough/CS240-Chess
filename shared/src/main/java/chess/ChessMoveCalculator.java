package chess;
import java.util.ArrayList;

import chess.piece.ChessPiece;
import chess.piece.*;

import java.util.List;

public class ChessMoveCalculator {

    /**
     * Takes in a board, piece, and position
     * @return a list of all valid chess Moves
     */
    public static chess.ChessMove[] CalculateMoves (chess.ChessBoard board, ChessPiece piece, chess.ChessPosition pos) {
        List<chess.ChessMove> moves = new ArrayList<>();
        switch (piece.getPieceType()) {
            default:break;
        }
        return null;
    }
}
