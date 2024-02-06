package chess;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
/**
 * For a class that can manage a chess game, making moves on a board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessGame {

    private chess.ChessBoard board = new ChessBoard();
    private TeamColor turn = TeamColor.WHITE;
    private boolean currentGame = false;

    public ChessGame() {

    }

    public void initializeGame() {
        turn = TeamColor.WHITE;
        currentGame = true;
        board.resetBoard();
    }

    public TeamColor getTeamTurn() { return turn; }
    public void setTeamTurn(TeamColor team) {
        turn = team;
    }

    public enum TeamColor {
        WHITE,
        BLACK
    }

    /**
     * Gets valid moves for a piece at the given location
     *
     * @param startPosition the piece to get valid moves for
     * @return Set of valid moves for requested piece, or null if no piece at
     * startPosition
     */
    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        if (!board.isValidSquare(startPosition)) { return null; }
        ChessPiece piece = board.getPiece(startPosition);
        if (piece == null) { return null; }
        return piece.pieceMoves(board);
    }

    public void makeMove(ChessMove move) throws InvalidMoveException {
        ChessPiece piece = board.getPiece(move.startPosition);
        if(piece == null) { throw new InvalidMoveException("piece does not exist"); }
        //if(piece.getTeamColor() != getTeamTurn()) { throw new InvalidMoveException("wrong color"); }

        boolean inValidMoves = false;
        Collection<ChessMove> moves = validMoves(move.getStartPosition());
        if(moves.isEmpty()) { throw new InvalidMoveException("no moves at start position"); }
        for(ChessMove possibleMove : moves) {
            if (possibleMove.equals(move)) { inValidMoves = true; break;}
        }

        if(inValidMoves) {
            board.MovePiece(move);
        }
    }

    public boolean isInCheck(TeamColor teamColor) {
        // get king piece
        // check all squares for pieces of opposite type

        ChessPiece king = board.getPiece(ChessPiece.PieceType.KING, teamColor);
        if(king == null) { return false; }

        for(int i=1; i < 8; i++) {
            for(int j=1; j < 8; j++) {
                ChessPiece piece = board.getPiece(new ChessPosition(i,j));
                if (piece == null) { continue; }
                if(piece.getTeamColor() != teamColor) {
                    Collection<ChessMove> moves = validMoves(piece.position);
                    for(ChessMove move : moves) {
                        if(move.endPosition.equals(king.position)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean isInCheckmate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
        // get king piece
        // check if king is in check
        //  check if moving king exits check
        //  check if moving other pieces resolves check
        //      check if blocks check
        //      check if stops piece from checking

    }
    public boolean isInStalemate(TeamColor teamColor) {
        throw new RuntimeException("Not implemented");
    }

    public void setBoard(ChessBoard board) { this.board = board; }
    public ChessBoard getBoard() {
        return board;
    }
}
