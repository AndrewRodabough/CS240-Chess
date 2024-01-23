package chess.piece;

import chess.*;

public class King extends LinearChessPiece {
    protected int maxSpaces = 1;
    protected boolean orthogonal = true;
    protected boolean diagonal = true;

    public King(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) { super(pieceColor, type); }
}
