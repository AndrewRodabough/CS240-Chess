package chess.piece;

import chess.ChessGame;
import chess.ChessPiece;
import chess.move.FiniteMoveGetter;
import chess.move.LinearMoveGetter;
import chess.move.PossibleMove;

import java.util.ArrayList;
import java.util.Collection;

public class Bishop extends ChessPiece {
    private static LinearMoveGetter linearMoves;

    static {
        Collection<PossibleMove> linear = new ArrayList<>();
        linear.add(new PossibleMove(-1, -1,true,true, false, false));
        linear.add(new PossibleMove(-1, 1,true,true, false, false));
        linear.add(new PossibleMove(1, -1,true,true, false, false));
        linear.add(new PossibleMove(1, 1,true,true, false, false));
        linearMoves = new LinearMoveGetter(linear, -1);

    }
    public Bishop(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this(pieceColor, type, false);
    }
    public Bishop(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, boolean hasMoved) {
        super(pieceColor, type, hasMoved);
        moveGetters.add(linearMoves);
    }
}
