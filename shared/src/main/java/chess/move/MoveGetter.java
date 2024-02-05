package chess.move;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class MoveGetter {
    private List<PossibleMove> possibleMoves = new ArrayList<>();
    public MoveGetter (Collection<PossibleMove> possibleMoves) {
        this.possibleMoves.addAll(possibleMoves);
    }
    public List<PossibleMove> getPossibleMoves() { return possibleMoves; }
    public abstract Collection<ChessMove> getValidMoves(ChessBoard board, ChessPosition position, boolean hasMoved, ChessGame.TeamColor teamColor);
}
