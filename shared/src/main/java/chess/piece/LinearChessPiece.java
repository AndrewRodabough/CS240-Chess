package chess.piece;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class LinearChessPiece extends ChessPiece {
    protected static int maxSpaces;
    protected static boolean orthogonal = false;
    protected static boolean diagonal = false;
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
    public LinearChessPiece (ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, int MaxSpaces, boolean Orthogonal, boolean Diagonal) {
        super(pieceColor, type);
        maxSpaces = MaxSpaces;
        orthogonal = Orthogonal;
        diagonal = Diagonal;
    }

    protected LinearChessPiece (ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        super(pieceColor, type);
    }

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> validMoves = new ArrayList<>();

        ChessPosition currentPos;
        if(diagonal) {
            for(ChessPosition vec : diagonalVec) {
                currentPos = myPosition;
                for(int j = 0; j < maxSpaces; j++) {
                    ChessPosition nextPos = currentPos.add(vec);
                    if(!board.positionExists(nextPos)) { break; }
                    ChessPiece piece = board.getPiece(nextPos);
                    if(piece == null) { validMoves.add(new ChessMove(myPosition, nextPos, PieceType.QUEEN)); currentPos = nextPos; continue; }
                    if(piece.getTeamColor() != this.color) { validMoves.add(new ChessMove(myPosition, nextPos, PieceType.QUEEN)); break; }
                }
            }
        }
        if(orthogonal) {
            for (ChessPosition vec : orthogonalVec) {
                currentPos = myPosition;
                for(int j = 0; j < maxSpaces; j++) {
                    ChessPosition nextPos = currentPos.add(vec);
                    if(!board.positionExists(nextPos)) { break; }
                    ChessPiece piece = board.getPiece(nextPos);
                    if(piece == null) { validMoves.add(new ChessMove(myPosition, nextPos, PieceType.QUEEN)); currentPos = nextPos; continue; }
                    if(piece.getTeamColor() != this.color) { validMoves.add(new ChessMove(myPosition, nextPos, PieceType.QUEEN)); break; }
                }
            }
        }
        return null;
    }
}
