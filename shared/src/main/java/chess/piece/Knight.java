package chess.piece;

import chess.*;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Knight extends FiniteChessPiece {

    public static List<ChessPosition> possibleMoves = new ArrayList<>();
    public static List<ChessPosition> possibleCaptures;
    static {
        possibleMoves.add(new ChessPosition(-2,-1));
        possibleMoves.add(new ChessPosition(-2,1));
        possibleMoves.add(new ChessPosition(2,-1));
        possibleMoves.add(new ChessPosition(2,1));
        possibleMoves.add(new ChessPosition(-1,-2));
        possibleMoves.add(new ChessPosition(-1,2));
        possibleMoves.add(new ChessPosition(1,-2));
        possibleMoves.add(new ChessPosition(1,2));
        possibleCaptures = possibleMoves;
    }
    public Knight(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        super(pieceColor, type, possibleMoves, possibleCaptures);
    }

    /*
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        return super.pieceMoves(board, myPosition);
    }
     */
}
