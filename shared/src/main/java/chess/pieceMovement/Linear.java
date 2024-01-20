package chess.pieceMovement;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

/**
 * Movement Pattern For Traveling equal amounts of spaces in a direction
 */
public class Linear extends MovePattern {

    static int maxSpaces;
    static boolean orthogonal;
    static boolean diagonal;

    public static ChessMove[] getMoves(ChessBoard board, ChessPiece piece, ChessPosition pos) {

        ChessPosition currentPos;
        if(diagonal) {
            for(ChessPosition vec : diagonalVec) {
                currentPos = pos;
                for(int j = 0; j < maxSpaces; j++) {
                    ChessPosition nextPos = currentPos += vec;
                    ChessPiece p = checkSquare();
                    if(p == null) { break; }
                    if(p.getTeamColor() == piece.getTeamColor()) { break; }
                    // add to list
                }
            }

        }
        if(orthogonal) {
            for (ChessPosition vec : orthogonalVec) {
                currentPos = pos;
                for (int j = 0; j < maxSpaces; j++) {
                    ChessPosition nextPos = currentPos += vec;
                    ChessPiece p = checkSquare();
                    if(p == null) { break; }
                    if(p.getTeamColor() == piece.getTeamColor()) { break; }
                    // add to list
                }
            }
        }

    }
}
