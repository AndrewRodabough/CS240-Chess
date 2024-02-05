package chess.piece;

import chess.*;
import chess.move.FiniteMoveGetter;
import chess.move.LinearLastMoveGetter;
import chess.move.LinearMoveGetter;
import chess.move.PossibleMove;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pawn extends ChessPiece{
    private int forward;
    private FiniteMoveGetter finiteMoves;
    private LinearLastMoveGetter linearLastMoves;

    public Pawn(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this(pieceColor, type, false);
    }
    public Pawn(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, boolean hasMoved) {
        super(pieceColor, type);
        forward = pieceColor == ChessGame.TeamColor.WHITE ? 1 : -1;

        Collection<PossibleMove> finite = new ArrayList<>();
        Collection<PossibleMove> linearLast = new ArrayList<>();
        finite.add(new PossibleMove(1 * forward, -1,true,false, false, true));
        finite.add(new PossibleMove(1 * forward, 1,true,false, false,true));
        finite.add(new PossibleMove(1 * forward,0,false, true, false,true));
        //linearLast.add(new PossibleMove(1 * forward,0,false, true, false,true));
        finiteMoves = new FiniteMoveGetter(finite);
        linearLastMoves = new LinearLastMoveGetter(linearLast, 2);

        moveGetters.add(finiteMoves);
        moveGetters.add(linearLastMoves);
    }
}