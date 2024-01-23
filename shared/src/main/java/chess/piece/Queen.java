package chess.piece;

import chess.*;

public class Queen extends LinearChessPiece {
    protected int maxSpaces = -1;
    protected boolean orthogonal = true;
    protected boolean diagonal = true;

    public Queen(ChessGame.TeamColor pieceColor, PieceType type) {
        super(pieceColor, type, -1, true, true);
    }
}
