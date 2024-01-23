package chess.piece;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends FiniteChessPiece {
    public int forward;
    protected static List<ChessPosition> possibleFirstMoves = new ArrayList<>();
    protected static List<ChessPosition> possibleMoves = new ArrayList<>();
    protected static List<ChessPosition> possibleCaptures = new ArrayList<>();

    static {
        possibleMoves.add(new ChessPosition(0,1));

        possibleCaptures.add(new ChessPosition(-1,1));
        possibleCaptures.add(new ChessPosition(1,1));

        possibleFirstMoves.add(new ChessPosition(0,2));
    }
    public Pawn(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        super(pieceColor, type);
        forward = pieceColor == ChessGame.TeamColor.WHITE ? -1 : 1;
    }

    @Override
    public Collection<ChessMove> pieceMoves (ChessBoard board, ChessPosition position) {
        //List<ChessMove> validMoves = super.pieceMoves(board, position).stream().toList();

        List<ChessMove> validMoves = new ArrayList<>();

        for(ChessPosition move : possibleMoves)
        {
            ChessPosition move2 = new ChessPosition(move.getColumn(), move.getRow() * forward);

            if (!board.positionExists(position.add(move2))) { continue; }
            ChessPiece piece = board.getPiece(position.add(move2));
            if (piece == null) { validMoves.add(new ChessMove(position, position.add(move2), PieceType.QUEEN)); }
        }
        for(ChessPosition move : possibleCaptures)
        {
            ChessPosition move2 = new ChessPosition(move.getColumn(), move.getRow() * forward);

            if (!board.positionExists(position.add(move2))) { continue; }
            ChessPiece piece = board.getPiece(position.add(move2));
            if (piece != null && piece.getTeamColor() != this.color) { validMoves.add(new ChessMove(position, position.add(move2), PieceType.QUEEN)); }
        }
        if (!hasMoved)
        {
            for(ChessPosition move : possibleFirstMoves)
            {
                ChessPosition move2 = new ChessPosition(move.getColumn(), move.getRow() * forward);

                if (!board.positionExists(position.add(move2))) { continue; }
                ChessPiece piece = board.getPiece(position.add(move2));
                if (piece == null) { validMoves.add(new ChessMove(position, position.add(move2), PieceType.QUEEN)); }
            }
        }
        return validMoves;
    }
}