package chess.piece;

import chess.*;
import chess.move.FiniteMoveGetter;
import chess.move.LinearLastMoveGetter;
import chess.move.PossibleMove;

import java.util.Collection;
import java.util.ArrayList;

public class Knight extends ChessPiece {
    private static FiniteMoveGetter finiteMoves;

    static {
        Collection<PossibleMove> finite = new ArrayList<>();
        finite.add(new PossibleMove(-2, -1,true,true, false, false));
        finite.add(new PossibleMove(-2, 1,true,true, false, false));
        finite.add(new PossibleMove(2, -1,true,true, false, false));
        finite.add(new PossibleMove(2, 1,true,true, false, false));
        finite.add(new PossibleMove(-1, -2,true,true, false, false));
        finite.add(new PossibleMove(-1, 2,true,true, false, false));
        finite.add(new PossibleMove(1, -2,true,true, false, false));
        finite.add(new PossibleMove(1, 2,true,true, false, false));
        finiteMoves = new FiniteMoveGetter(finite);
    }
    public Knight(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this(pieceColor, type, false);
    }
    public Knight(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, boolean hasMoved) {
        super(pieceColor, type, hasMoved);
        moveGetters.add(finiteMoves);
    }
}
