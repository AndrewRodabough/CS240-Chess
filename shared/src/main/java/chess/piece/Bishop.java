package chess.piece;

import chess.ChessGame;

public class Bishop extends LinearChessPiece {
    protected int maxSpaces = -1;
    protected boolean orthogonal = false;
    protected boolean diagonal = true;

    public Bishop(ChessGame.TeamColor pieceColor, PieceType type) {
        super(pieceColor, type, -1, false, true);
    }
}
