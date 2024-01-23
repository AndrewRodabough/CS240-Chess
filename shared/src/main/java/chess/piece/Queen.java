package chess.piece;

import chess.*;

public class Queen extends LinearChessPiece {
    protected int maxSpaces = -1;
    protected boolean orthogonal = true;
    protected boolean diagonal = true;

    public Queen(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) { super(pieceColor, type); }
}
