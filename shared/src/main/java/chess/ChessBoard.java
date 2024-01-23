package chess;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    ChessPiece[][] squares;
    public ChessBoard() {
        squares = new ChessPiece[8][8];
    }

    /**
     * Adds a chess piece to the chessboard
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {

        ChessPiece betterPiece = null;
        if (piece.getPieceType() == ChessPiece.PieceType.KING) {
            betterPiece = new chess.piece.King(piece.getTeamColor(), piece.getPieceType()); }
        else if (piece.getPieceType() == ChessPiece.PieceType.QUEEN) {
            betterPiece = new chess.piece.Queen(piece.getTeamColor(), piece.getPieceType()); }
        else if (piece.getPieceType() == ChessPiece.PieceType.ROOK) {
            betterPiece = new chess.piece.Rook(piece.getTeamColor(), piece.getPieceType()); }
        else if (piece.getPieceType() == ChessPiece.PieceType.BISHOP) {
            betterPiece = new chess.piece.Bishop(piece.getTeamColor(), piece.getPieceType()); }
        else if (piece.getPieceType() == ChessPiece.PieceType.KNIGHT) {
            betterPiece = new chess.piece.Knight(piece.getTeamColor(), piece.getPieceType()); }
        else if (piece.getPieceType() == ChessPiece.PieceType.PAWN) {
            betterPiece = new chess.piece.Pawn(piece.getTeamColor(), piece.getPieceType()); }
        betterPiece.position = position;
        squares[position.getRow()][position.getColumn()] = betterPiece;
    }

    /**
     * Gets a chess piece on the chessboard
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return squares[position.getRow()][position.getColumn()];
    }
    public boolean positionExists(ChessPosition pos) {
        int col =  pos.getColumn();
        int row =  pos.getRow();
        return col >= 1 && col <= 8 && row >= 1 && row <= 8;
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        throw new RuntimeException("Not implemented");
    }
}
