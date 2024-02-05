package chess.move;

import chess.*;

import java.util.Collection;
import java.util.ArrayList;

public class LinearMoveGetter extends MoveGetter{
    private int maxSpaces;
    public LinearMoveGetter(Collection<PossibleMove> possibleMoves, int maxSpaces) {
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
                ChessPosition newPos = new ChessPosition(move.offsetX() + currentPos.getRow(), move.offsetY() + currentPos.getColumn());
                if(!board.positionExists(newPos)) { break; }

                ChessPiece piece = board.getPiece(newPos);

                if(piece == null) {
                    if (move.canMoveIfEmpty()) {
                        if (move.canPromote()) {
                            for(ChessPiece.PieceType type : ChessPiece.PieceType.values()) {
                                validMoves.add(new ChessMove(position, newPos, type));
                            }
                        }
                        else {
                            validMoves.add(new ChessMove(position, newPos, null));
                        }
                    }
                }
                else if (move.canCapture() && piece.getTeamColor() != teamColor) {
                    if (move.canPromote()) {
                        for(ChessPiece.PieceType type : ChessPiece.PieceType.values()) {
                            validMoves.add(new ChessMove(position, newPos, type));
                        }
                    }
                    else {
                        validMoves.add(new ChessMove(position, newPos, null));
                    }
                    break;
                }
                currentPos = newPos;
            }
        }
        return validMoves;
    }
}
