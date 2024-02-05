package chess.move;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;

public class FiniteMoveGetter extends MoveGetter{
    public FiniteMoveGetter(Collection<PossibleMove> possibleMoves) {
        super(possibleMoves);
    }
    public Collection<ChessMove> getValidMoves(ChessBoard board, ChessPosition position, boolean hasMoved, ChessGame.TeamColor teamColor) {

        Collection<ChessMove> validMoves = new ArrayList<>();
        for(PossibleMove move : getPossibleMoves())
        {
            ChessPosition newPos = new ChessPosition(move.offsetX() + position.getRow(), move.offsetY() + position.getColumn());
            if (move.forFirstMove() && hasMoved) { continue; }
            if (!board.positionExists(newPos)) { continue; }

            ChessPiece piece = board.getPiece(newPos);

            if ((piece == null && move.canMoveIfEmpty()) ||
                 (piece != null && move.canCapture() && piece.getTeamColor() != teamColor)) {
                if (move.canPromote() && board.canPromote(newPos, teamColor)) {
                    for(ChessPiece.PieceType type : ChessPiece.PieceType.values()) {
                        validMoves.add(new ChessMove(position, newPos, type));
                    }
                }
                else {
                    validMoves.add(new ChessMove(position, newPos, null));
                }

            }
        }

        return validMoves;
    }
}
