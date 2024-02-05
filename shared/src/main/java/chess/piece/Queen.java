package chess.piece;

import chess.*;
import chess.move.LinearMoveGetter;
import chess.move.PossibleMove;

import java.util.ArrayList;
import java.util.Collection;

public class Queen extends ChessPiece {
    private static LinearMoveGetter linearMoves;

    static {
        Collection<PossibleMove> linear = new ArrayList<>();
        linear.add(new PossibleMove(-1, -1,true,true, false, false));
        linear.add(new PossibleMove(-1, 1,true,true, false, false));
        linear.add(new PossibleMove(1, -1,true,true, false, false));
        linear.add(new PossibleMove(1, 1,true,true, false, false));
        linear.add(new PossibleMove(-1, 0,true,true, false, false));
        linear.add(new PossibleMove(1, 0,true,true, false, false));
        linear.add(new PossibleMove(0, -1,true,true, false, false));
        linear.add(new PossibleMove(0, 1,true,true, false, false));
        linearMoves = new LinearMoveGetter(linear, -1);
    }
    public Queen(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this(pieceColor, type, false);
    }
    public Queen(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, boolean hasMoved) {
        super(pieceColor, type, hasMoved);
        moveGetters.add(linearMoves);
    }
}
