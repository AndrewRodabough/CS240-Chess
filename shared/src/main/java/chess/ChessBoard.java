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
            betterPiece = new chess.piece.Pawn(piece.getTeamColor(), piece.getPieceType());
            boolean moved = true;
            if(betterPiece.color.ordinal() == ChessPiece.Color.BLACK.ordinal()) {
                if(position.getRow() == 7) {
                    moved = false;
                }
            }
            else {
                if(position.getRow() == 2) {
                    moved = false;
                }
            }
            betterPiece.hasMoved = moved;
        }

        betterPiece.position = position;
        squares[position.getRow() - 1][position.getColumn() - 1] = betterPiece;
    }

    /**
     * Gets a chess piece on the chessboard
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {

        return squares[position.getRow() - 1][position.getColumn() - 1];
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
        squares = new ChessPiece[8][8];
        addPiece(new ChessPosition(1,1), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK));
        addPiece(new ChessPosition(1,2), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(1,3), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(1,4), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.QUEEN));
        addPiece(new ChessPosition(1,5), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KING));
        addPiece(new ChessPosition(1,6), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(1,7), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(1,8), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.ROOK));

        addPiece(new ChessPosition(8,1), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK));
        addPiece(new ChessPosition(8,2), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(8,3), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(8,4), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.QUEEN));
        addPiece(new ChessPosition(8,5), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KING));
        addPiece(new ChessPosition(8,6), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(8,7), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(8,8), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.ROOK));

        addPiece(new ChessPosition(2,1), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(2,2), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(2,3), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(2,4), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(2,5), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(2,6), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(2,7), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(2,8), new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN));

        addPiece(new ChessPosition(7,1), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(7,2), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(7,3), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(7,4), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(7,5), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(7,6), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(7,7), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
        addPiece(new ChessPosition(7,8), new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN));
    }

    @Override
    public int hashCode() {

        int hash = 0;
        for(int i=1; i < 8; i++) {
            for(int j=0; j < 8; j++) {
                ChessPiece piece = getPiece(new ChessPosition(i,j));
                if(piece != null) {
                    hash += piece.hashCode();
                }
            }
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ChessBoard)) return false;
        ChessBoard o = (ChessBoard) obj;

        boolean isSame = true;
        for(int i=1; i < 8; i++) {
            for(int j=1; j < 8; j++) {
                ChessPiece piece = getPiece(new ChessPosition(i,j));
                ChessPiece piece2 = o.getPiece(new ChessPosition(i,j));
                if(piece != null) {
                    if(piece2 != null) {
                        if(!piece.equals(piece2)) {
                            isSame = false;
                        }
                    }
                    else {
                        isSame = false;
                    }
                }
                else {
                    if(piece2 != null) {
                        isSame =false;
                    }
                }
            }
        }
        return isSame;
    }
}
