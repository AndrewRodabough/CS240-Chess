package chess.move;

import chess.*;

import java.util.ArrayList;
import java.util.Collection;

public class LinearLastMoveGetter extends MoveGetter{
    private int maxSpaces;
    public LinearLastMoveGetter(Collection<PossibleMove> possibleMoves, int maxSpaces) {
        super(possibleMoves);
        this.maxSpaces = maxSpaces;
    }
    @Override
    public Collection<ChessMove> getValidMoves(ChessBoard board, ChessPosition position, boolean hasMoved, ChessGame.TeamColor teamColor) {
        Collection<ChessMove> validMoves = new ArrayList<>();

        for(PossibleMove move : getPossibleMoves()) {

            if (move.forFirstMove() && hasMoved) { continue; }

            ChessPosition currentPos = position;
            for(int i = 0; i != maxSpaces; i++) {
                ChessPosition newPos = new ChessPosition(move.offsetY() + currentPos.getRow(), move.offsetX() + currentPos.getColumn());
                if(!board.positionExists(newPos)) { break; }

                ChessPiece piece = board.getPiece(newPos);

                if (piece != null && move.canCapture() && piece.getTeamColor() != teamColor) {
                    if (position == currentPos) { break; }
                    if (move.canPromote() && board.canPromote(newPos, teamColor)) {
                        for(ChessPiece.PieceType type : ChessPiece.PieceType.values()) {
                            validMoves.add(new ChessMove(position, currentPos, type));
                        }
                    }
                    else {
                        validMoves.add(new ChessMove(position, currentPos, null));
                    }
                    break;
                }
                currentPos = newPos;
            }
        }
        return validMoves;
    }
}
