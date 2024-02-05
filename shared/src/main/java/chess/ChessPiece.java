package chess;

import chess.move.MoveGetter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private ChessGame.TeamColor color;
    private ChessPiece.PieceType type;
    private ChessPosition position;
    private boolean hasMoved;
    protected ArrayList<MoveGetter> moveGetters = new ArrayList<>();

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this(pieceColor, type, false);
    }
    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type, boolean hasMoved) {
        this.color = pieceColor;
        this.type = type;
        this.hasMoved = hasMoved;
    }

    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    public ChessGame.TeamColor getTeamColor() { return color; }
    public PieceType getPieceType() { return type; }
    public Boolean getHasMoved() { return hasMoved; }
    public ChessPosition getPosition() { return position; }

    public void setHasMoved(boolean hasMoved) { this.hasMoved = hasMoved; }
    public void setPosition(ChessPosition position) { this.position = position; }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> validMoves = new ArrayList<>();
        for (MoveGetter getter : moveGetters) {
            validMoves.addAll(getter.getValidMoves(board,myPosition,hasMoved,color));
        }
        return validMoves;
    }
    public Collection<ChessMove> pieceMoves(ChessBoard board) { return pieceMoves(board, position); }

    public int hashCode() {
        return Objects.hash(color, type);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessPiece that = (ChessPiece) o;
        return color == that.color && type == that.type;
    }
    public String toString() {
        String s = "Piece(" + color.name() + "," + type.name() + ")";
        return s;
    }
}
