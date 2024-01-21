package chess.piece;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;

public class Bishop extends LinearChessPiece {
    protected static int maxSpaces = -1;
    protected static boolean orthogonal = false;
    protected static boolean diagonal = true;

    public Bishop(ChessGame.TeamColor pieceColor, PieceType type) {
        super(pieceColor, type);
    }
}
