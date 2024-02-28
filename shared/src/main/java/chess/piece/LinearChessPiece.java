package chess.piece;

import chess.*;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class LinearChessPiece extends ChessPiece {
    protected int maxSpaces = 0;
    protected boolean orthogonal = false;
    protected boolean diagonal = false;
    protected static List<ChessPosition> diagonalVec = new ArrayList<>();
    protected static List<ChessPosition> orthogonalVec = new ArrayList<>();

    static {
        orthogonalVec.add(new ChessPosition(-1,0));
        orthogonalVec.add(new ChessPosition(1,0));
        orthogonalVec.add(new ChessPosition(0,-1));
        orthogonalVec.add(new ChessPosition(0,1));

        diagonalVec.add(new ChessPosition(-1,-1));
        diagonalVec.add(new ChessPosition(-1,1));
        diagonalVec.add(new ChessPosition(1,1));
        diagonalVec.add(new ChessPosition(1,-1));
    }
    public LinearChessPiece (ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, int maxSpaces, boolean orthogonal, boolean diagonal) {
        super(pieceColor, type);
        this.maxSpaces = maxSpaces;
        this.orthogonal = orthogonal;
        this.diagonal = diagonal;
    }

    protected LinearChessPiece (ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        super(pieceColor, type);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> validMoves = new ArrayList<>();

        ChessPosition currentPos;
        getMoves(board, myPosition, validMoves, diagonal, diagonalVec);
        getMoves(board, myPosition, validMoves, orthogonal, orthogonalVec);
        return validMoves;
    }

    private void getMoves(ChessBoard board, ChessPosition myPosition, Collection<ChessMove> validMoves, boolean diagonal, List<ChessPosition> diagonalVec) {
        ChessPosition currentPos;
        if(diagonal) {
            for(ChessPosition vec : diagonalVec) {
                currentPos = myPosition;
                for(int j = 0; j != maxSpaces; j++) {
                    ChessPosition nextPos = currentPos.add(vec);
                    if(!board.positionExists(nextPos)) { break; }
                    ChessPiece piece = board.getPiece(nextPos);
                    if(piece == null) { validMoves.add(new ChessMove(myPosition, nextPos, null)); currentPos = nextPos;  continue; }
                    if(piece.getTeamColor() != this.color) { validMoves.add(new ChessMove(myPosition, nextPos, null)); break; }
                    else { break;}
                }
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
