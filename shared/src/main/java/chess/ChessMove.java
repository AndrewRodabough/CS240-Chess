package chess;

/**
 * Represents moving a chess piece on a chessboard
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessMove {

    ChessPosition startPosition;
    ChessPosition endPosition;
    ChessPiece.PieceType promotionPiece;

    public ChessMove(ChessPosition startPosition, ChessPosition endPosition, ChessPiece.PieceType promotionPiece) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.promotionPiece = promotionPiece;
    }

    public ChessPosition getStartPosition() { return this.startPosition; }
    public ChessPosition getEndPosition() { return this.endPosition; }

    /**
     * Gets the type of piece to promote a pawn to if pawn promotion is part of this
     * chess move
     *
     * @return Type of piece to promote a pawn to, or null if no promotion
     */
    public ChessPiece.PieceType getPromotionPiece() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public int hashCode() {
        int startH = startPosition.hashCode();
        int endH = endPosition.hashCode();
        int hash;
        if(promotionPiece == null) {
            hash = startH + endH;
        }
        else {
            int promotionH = promotionPiece.hashCode();
            hash = startH + endH + promotionH;
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ChessMove)) return false;
        ChessMove o = (ChessMove) obj;
        if (this.promotionPiece == null) {
            if (o.promotionPiece == null) {
                return this.startPosition.equals(o.startPosition) &&
                        this.endPosition.equals(o.endPosition);
            }
            else {
                return false;
            }
        }
        else {
            return this.startPosition.equals(o.startPosition) &&
                    this.endPosition.equals(o.endPosition) &&
                    this.promotionPiece.equals(o.promotionPiece);
        }

    }

    @Override
    public String toString() {
        String s = "Move(start:" + startPosition.toString() + ", End:" + endPosition.toString() + ", Promo:";
        if(promotionPiece == null) {
            s += "None";
        }
        else {
            s += promotionPiece.toString();
        }
        s += ")";
        return s;
    }

}
