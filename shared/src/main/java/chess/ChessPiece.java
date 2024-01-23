package chess;

import java.util.Collection;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    protected final ChessGame.TeamColor color;
    protected final ChessPiece.PieceType type;
    protected ChessPosition position;
    public boolean hasMoved;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.color = pieceColor;
        this.type = type;
        hasMoved = false;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }
    public enum Color {
        WHITE,
        BLACK
    }

    public ChessGame.TeamColor getTeamColor() { return color; }
    public PieceType getPieceType() { return type; }
    public Boolean getHasMoved() { return hasMoved; }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) { return null;}
    public Collection<ChessMove> pieceMoves(ChessBoard board) { return pieceMoves(board, position); }

    @Override
    public int hashCode() {
        int colorI = color.ordinal();
        int typeI = type.ordinal();
        //int posH = position.hashCode();
        int hash1 = colorI >= typeI ? colorI * colorI + colorI + typeI : colorI + typeI * typeI;
        //int hash2 = posH + hash1;
        //hash1 *= this.hasMoved ? 11 : 29;
        return hash1;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ChessPiece)) return false;
        ChessPiece o = (ChessPiece) obj;
        /*
        return this.type == o.type &&
                this.color == o.color &&
                this.position.equals(o.position) &&
                this.hasMoved == o.hasMoved;

         */
        return this.type == o.type && this.color == o.color;
    }

    @Override
    public String toString() {
        String s = "Piece(" + color.name() + "," + type.name() + ")";
        return s;
    }
}
