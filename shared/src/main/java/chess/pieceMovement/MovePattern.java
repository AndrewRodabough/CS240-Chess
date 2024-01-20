package chess.pieceMovement;

import chess.ChessPiece;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.List;

public class MovePattern {

    protected static List<ChessPosition> diagonalVec = new ArrayList<>();
    protected static List<ChessPosition> orthogonalVec = new ArrayList<>();

    static {
        orthogonalVec.add(new ChessPosition(-1,0));
        orthogonalVec.add(new ChessPosition(1,0));
        orthogonalVec.add(new ChessPosition(0,-1));
        orthogonalVec.add(new ChessPosition(0,1));

        diagonalVec.add(new ChessPosition(-1,-1));
        diagonalVec.add(new ChessPosition(-1,1));
        diagonalVec.add(new ChessPosition(1,1));
        diagonalVec.add(new ChessPosition(1,-1));
    }

    public static chess.ChessMove[] getMoves(chess.ChessBoard board, ChessPiece piece, chess.ChessPosition pos) {
        return null;
    }

    public static int checkSquare(chess.ChessBoard board, chess.ChessPosition pos) {
        boolean onBoard = board.ValidPos(pos);
        if(onBoard) {
            ChessPiece piece = board.getSquare();
            if (piece == null) {
                return 0;
            }
            else {
                return 1;
            }

        }
        return -1;
    }
}
