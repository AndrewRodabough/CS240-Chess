package chess.pieceMovement;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

/**
 * Movement Pattern For Traveling equal amounts of spaces in a direction
 */
public class Linear extends MovePattern {

    /**
     * -1 if infinite spaces
     */
    int maxSpaces;

    /*
     * int maxDirections;
     */

    /**
     * determines if piece can move orthogonally
     */
    boolean orthogonal;

    /**
     * determines if piece can move diagonally
     */
    boolean diagonal;

    public Linear(int maxSpaces, boolean orthogonal, boolean diagonal) {
        this.maxSpaces = maxSpaces;
        this.diagonal = diagonal;
        this.orthogonal = orthogonal;
    }

    /*
    public int getMaxSpaces() { return maxSpaces; }
    public boolean getOrthogonal() { return orthogonal; }
    public boolean getDiagonal() { return diagonal; }
    */

}
