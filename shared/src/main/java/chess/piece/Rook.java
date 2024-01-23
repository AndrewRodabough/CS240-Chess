package chess.piece;

import chess.*;

public class Rook extends LinearChessPiece {
    protected int maxSpaces = -1;
    protected boolean orthogonal = true;
    protected boolean diagonal = false;

    public Rook(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) { super(pieceColor, type); }

}
