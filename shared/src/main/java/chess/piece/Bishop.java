package chess.piece;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;

public class Bishop extends LinearChessPiece {
    protected int maxSpaces = -1;
    protected boolean orthogonal = false;
    protected boolean diagonal = true;

    public Bishop(ChessGame.TeamColor pieceColor, PieceType type) {
        super(pieceColor, type, -1, false, true);
    }
}
