package chess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import chess.pieceMovement.*;
import java.util.ArrayList;
import java.util.List;

public class ChessMoveCalculator {

    /**
     * Takes in a board, piece, and position
     * @return a list of all valid chess Moves
     */
    public static chess.ChessMove[] CalculateMoves (chess.ChessBoard board, ChessPiece piece, chess.ChessPosition pos) {
        List<chess.ChessMove> moves = new ArrayList<>();
        switch (piece.getPieceType()) {
            case(ChessPiece.PieceType.KING):
                break;
            case(ChessPiece.PieceType.QUEEN):
                break;
            case(ChessPiece.PieceType.BISHOP):
                break;
            case(ChessPiece.PieceType.ROOK):
                break;
            case(ChessPiece.PieceType.KNIGHT):
                break;
            case(ChessPiece.PieceType.PAWN):
                break;

        }
        MovePattern movement = movements.get(piece.getPieceType());
        return movement.getMoves(board, piece, pos);
    }
}
