package chess.piece;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;

public class Rook extends LinearChessPiece {
    protected static int maxSpaces = -1;
    protected static boolean orthogonal = true;
    protected static boolean diagonal = false;

    public Rook(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) { super(pieceColor, type); }

}
