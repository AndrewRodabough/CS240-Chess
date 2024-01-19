package chess;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import chess.pieceMovement.*;

public class ChessMoveCalculator {
    static Map<ChessPiece.PieceType, MovePattern> movements;

    static {
        MovePattern king = new Linear(1,true,true);
        MovePattern queen = new Linear(-1,true,true);
        MovePattern rook = new Linear(-1,true,false);
        MovePattern bishop = new Linear(-1,false,true);
        MovePattern knight = new Knight();
        MovePattern pawn = new Pawn();

        movements = new HashMap<>();
        movements.put(ChessPiece.PieceType.KING, king);
        movements.put(ChessPiece.PieceType.QUEEN, queen);
        movements.put(ChessPiece.PieceType.ROOK, rook);
        movements.put(ChessPiece.PieceType.BISHOP, bishop);
        movements.put(ChessPiece.PieceType.KNIGHT, knight);
        movements.put(ChessPiece.PieceType.PAWN, pawn);
    }

    /**
     * Takes in a board, piece, and position
     * @return a list of all valid chess Moves
     */
    public static chess.ChessMove[] CalculateMoves (chess.ChessBoard board, ChessPiece piece, chess.ChessPosition pos) {
        MovePattern movement = movements.get(piece.getPieceType());
        return movement.getMoves(board, piece, pos);
    }
}
