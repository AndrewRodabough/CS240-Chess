package chess.piece;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FiniteChessPiece extends ChessPiece {

    public static List<ChessPosition> possibleMoves = new ArrayList<>();
    public static List<ChessPosition> possibleCaptures = new ArrayList<>();

    public FiniteChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        super(pieceColor, type);
    }
    public FiniteChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, List<ChessPosition> possibleMoves, List<ChessPosition> possibleCaptures) {
        super(pieceColor, type);
        this.possibleMoves = possibleMoves;
        this.possibleCaptures = possibleCaptures;
    }
    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        Collection<ChessMove> validMoves = new ArrayList<>();
        for(ChessPosition move : this.possibleMoves)
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
