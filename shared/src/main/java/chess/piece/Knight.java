package chess.piece;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Knight extends ChessPiece {

    protected static List<ChessPosition> possibleMoves = new ArrayList<>();
    protected static List<ChessPosition> possibleCaptures;
    static {
        possibleMoves.add(new ChessPosition(-2,-1));
        possibleMoves.add(new ChessPosition(-2,1));
        possibleMoves.add(new ChessPosition(2,-1));
        possibleMoves.add(new ChessPosition(2,1));
        possibleMoves.add(new ChessPosition(-1,-2));
        possibleMoves.add(new ChessPosition(-1,2));
        possibleMoves.add(new ChessPosition(1,-2));
        possibleMoves.add(new ChessPosition(1,2));
        possibleCaptures = new ArrayList<>();
    }
    public Knight(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        super(pieceColor, type);
    }
}
