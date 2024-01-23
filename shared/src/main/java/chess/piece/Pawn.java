package chess.piece;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends FiniteChessPiece {
    public int forward;
    protected static List<ChessPosition> possibleMoves = new ArrayList<>();
    protected static List<ChessPosition> possibleCaptures = new ArrayList<>();

    static {
        possibleMoves.add(new ChessPosition(1,0));

        possibleCaptures.add(new ChessPosition(1,-1));
        possibleCaptures.add(new ChessPosition(1,1));
    }
    public Pawn(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        super(pieceColor, type, possibleMoves, possibleCaptures);
        forward = pieceColor == ChessGame.TeamColor.WHITE ? 1 : -1;
    }

    @Override
    public Collection<ChessMove> pieceMoves (ChessBoard board, ChessPosition position) {
        //List<ChessMove> validMoves = super.pieceMoves(board, position).stream().toList();

        List<ChessMove> validMoves = new ArrayList<>();

        for(ChessPosition move : possibleMoves)
        {
            ChessPosition move2 = new ChessPosition(move.getRow() * forward, move.getColumn());

            if (!board.positionExists(position.add(move2))) { continue; }
            ChessPiece piece = board.getPiece(position.add(move2));

            if (piece == null) {
                if (color.ordinal() == Color.BLACK.ordinal() && position.add(move2).getRow() == 1 ||
                        color.ordinal() == Color.WHITE.ordinal() && position.add(move2).getRow() == 8 ) {
                    validMoves.add(new ChessMove(position, position.add(move2), PieceType.QUEEN));
                    validMoves.add(new ChessMove(position, position.add(move2), PieceType.ROOK));
                    validMoves.add(new ChessMove(position, position.add(move2), PieceType.BISHOP));
                    validMoves.add(new ChessMove(position, position.add(move2), PieceType.KNIGHT));
                }
                else {
                    validMoves.add(new ChessMove(position, position.add(move2), null));
                }
            }
        }
        for(ChessPosition move : possibleCaptures)
        {
            ChessPosition move2 = new ChessPosition(move.getRow() * forward, move.getColumn());

            if (!board.positionExists(position.add(move2))) { continue; }
            ChessPiece piece = board.getPiece(position.add(move2));

            if (piece != null && piece.getTeamColor() != this.color) {
                if (color.ordinal() == Color.BLACK.ordinal() && position.add(move2).getRow() == 1 ||
                        color.ordinal() == Color.WHITE.ordinal() && position.add(move2).getRow() == 8 ) {
                    validMoves.add(new ChessMove(position, position.add(move2), PieceType.QUEEN));
                    validMoves.add(new ChessMove(position, position.add(move2), PieceType.ROOK));
                    validMoves.add(new ChessMove(position, position.add(move2), PieceType.BISHOP));
                    validMoves.add(new ChessMove(position, position.add(move2), PieceType.KNIGHT));
                }
                else {
                    validMoves.add(new ChessMove(position, position.add(move2), null));
                }
            }
        }
        if (!hasMoved)
        {
            ChessPosition move1 = new ChessPosition(1 * forward, 0);
            ChessPosition move2 = new ChessPosition(2 * forward, 0);
            if(board.positionExists(position.add(move1)) && board.positionExists(position.add(move2))) {
                ChessPiece piece1 = board.getPiece(position.add(move1));
                ChessPiece piece2 = board.getPiece(position.add(move2));
                if(piece1 == null && piece2 == null) {
                    validMoves.add(new ChessMove(position, position.add(move2), null));
                }
            }
        }
        return validMoves;
    }
}