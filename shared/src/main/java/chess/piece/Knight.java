package chess.piece;

import chess.*;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Knight extends ChessPiece{

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
        super(pieceColor, type);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        Collection<ChessMove> validMoves = new ArrayList<>();
        for(ChessPosition move : possibleMoves)
        {
            if (!board.positionExists(position.add(move))) { continue; }
            ChessPiece piece = board.getPiece(position.add(move));
            if (piece == null) { validMoves.add(new ChessMove(position, position.add(move), null)); }
        }
        for(ChessPosition move : possibleCaptures)
        {
            if (!board.positionExists(position.add(move))) { continue; }
            ChessPiece piece = board.getPiece(position.add(move));
            if (piece != null && piece.getTeamColor() != this.color) { validMoves.add(new ChessMove(position, position.add(move), null)); }
        }

        return validMoves;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
