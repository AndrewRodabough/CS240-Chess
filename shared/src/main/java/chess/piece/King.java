package chess.piece;

import chess.*;
import chess.move.*;

import java.util.ArrayList;
import java.util.Collection;

public class King extends ChessPiece{
    private static LinearMoveGetter linearMoves;
    private static Collection<MoveGetter> checkChecker = new ArrayList<>();

    static {
        Collection<PossibleMove> linear = new ArrayList<>();
        Collection<PossibleMove> finite = new ArrayList<>();
        linear.add(new PossibleMove(-1, -1,true,true, false, false));
        linear.add(new PossibleMove(-1, 1,true,true, false, false));
        linear.add(new PossibleMove(1, -1,true,true, false, false));
        linear.add(new PossibleMove(1, 1,true,true, false, false));
        linear.add(new PossibleMove(-1, 0,true,true, false, false));
        linear.add(new PossibleMove(1, 0,true,true, false, false));
        linear.add(new PossibleMove(0, -1,true,true, false, false));
        linear.add(new PossibleMove(0, 1,true,true, false, false));
        finite.add(new PossibleMove(-2, -1,true,true, false, false));
        finite.add(new PossibleMove(-2, 1,true,true, false, false));
        finite.add(new PossibleMove(2, -1,true,true, false, false));
        finite.add(new PossibleMove(2, 1,true,true, false, false));
        finite.add(new PossibleMove(-1, -2,true,true, false, false));
        finite.add(new PossibleMove(-1, 2,true,true, false, false));
        finite.add(new PossibleMove(1, -2,true,true, false, false));
        finite.add(new PossibleMove(1, 2,true,true, false, false));

        linearMoves = new LinearMoveGetter(linear, 1);
        checkChecker.add(new LinearMoveGetter(linear, -1));
        checkChecker.add(new FiniteMoveGetter(finite));
    }
    public King(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this(pieceColor, type, false);
    }
    public King(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, boolean hasMoved) {
        super(pieceColor, type, hasMoved);
        moveGetters.add(linearMoves);
    }
}
