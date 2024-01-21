package chess.piece;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FiniteChessPiece extends ChessPiece{

    protected static List<ChessPosition> possibleMoves = new ArrayList<>();
    protected static List<ChessPosition> possibleCaptures = new ArrayList<>();

    public FiniteChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        super(pieceColor, type);
    }

    @Override
    public Collection<ChessMove> pieceMoves (ChessBoard board, ChessPosition position) {
        Collection<ChessMove> validMoves = new ArrayList<>();
        for(ChessPosition move : possibleMoves)
        {
            if (!board.positionExists(position.add(move))) { continue; }
            ChessPiece piece = board.getPiece(position.add(move));
            if (piece == null) { validMoves.add(new ChessMove(position, position.add(move), PieceType.QUEEN)); }
        }
        for(ChessPosition move : possibleCaptures)
        {
            if (!board.positionExists(position.add(move))) { continue; }
            ChessPiece piece = board.getPiece(position.add(move));
            if (piece != null || piece.getTeamColor() != this.color) { validMoves.add(new ChessMove(position, position.add(move), PieceType.QUEEN)); }
        }

        return validMoves;
    }
}
