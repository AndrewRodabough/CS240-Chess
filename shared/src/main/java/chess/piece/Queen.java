package chess.piece;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;

public class Queen extends LinearChessPiece {
    protected static int maxSpaces = -1;
    protected static boolean orthogonal = true;
    protected static boolean diagonal = true;

    public Queen(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) { super(pieceColor, type); }
}
