package chess;

import java.util.Collection;
import java.util.ArrayList;

public class ChessGame {

    private chess.ChessBoard board = new ChessBoard();
    private ChessGame.TeamColor turn = ChessGame.TeamColor.WHITE;

    public ChessGame() {

    }
    public void initializeGame() {
        turn = ChessGame.TeamColor.WHITE;
        board.resetBoard();
    }
    public ChessGame.TeamColor getTeamTurn() { return turn; }
    public void setTeamTurn(ChessGame.TeamColor team) {
        turn = team;
    }
    public enum TeamColor {
        WHITE,
        BLACK
    }

    public Collection<ChessMove> validMoves(ChessPosition startPosition) {
        // check position exists on board and has a piece on it
        if (!board.isValidSquare(startPosition)) { return new ArrayList<>(); }
        ChessPiece piece = board.getPiece(startPosition);
        if (piece == null) { return new ArrayList<>(); }

        // get all moves allowed by piece movement
        Collection<ChessMove> moves = piece.pieceMoves(board);

        // check that moves do not violate check
        Collection<ChessMove> valid = new ArrayList<>();
        for(ChessMove move : moves) {
            ChessBoard testBoard = board.copy();
            testBoard.MovePiece(move);
            if(!isInCheck(piece.getTeamColor(), testBoard)) { valid.add(move); }
        }
        return valid;
    }
    public void switchTurn() {
        if (getTeamTurn() == TeamColor.WHITE) { setTeamTurn(TeamColor.BLACK); }
        else { setTeamTurn(TeamColor.WHITE); }
    }
    public void makeMove(ChessMove move) throws InvalidMoveException {

        // check piece is at the start and is the correct color
        ChessPiece piece = board.getPiece(move.startPosition);
        if(piece == null) { throw new InvalidMoveException("no piece at start position"); }
        if(piece.getTeamColor() != getTeamTurn()) { throw new InvalidMoveException("wrong color"); }


        // check that there are valid moves at the position
        Collection<ChessMove> moves = validMoves(move.getStartPosition());
        if(moves.isEmpty()) { throw new InvalidMoveException("no moves at start position"); }

        // check if proposed move is in the list of valid moves
        boolean inValidMoves = false;
        for(ChessMove possibleMove : moves) {
            if (possibleMove.equals(move)) {
                inValidMoves = true;
                break;
            }
        }

        // when move is not in list
        if(!inValidMoves) {
            throw new InvalidMoveException("Move Invalid");
        }

        //move piece and switch turn
        board.MovePiece(move);
        switchTurn();
    }

    public boolean isInCheck(TeamColor color, ChessBoard testBoard) {
        // given a theoretical board
        // get king piece
        // check all squares for pieces of opposite type
        // if opposing team has a piece that can move to king square, king is in check

        ChessPiece king = testBoard.getPiece(ChessPiece.PieceType.KING, color);
        if(king == null) { return false; }

        for(int i=1; i <= 8; i++) {
            for(int j=1; j <= 8; j++) {

                ChessPiece piece = testBoard.getPiece(new ChessPosition(i,j));
                if (piece == null) { continue; }
                if(piece.getTeamColor() == color) { continue; }

                Collection<ChessMove> moves = piece.pieceMoves(testBoard);
                for(ChessMove move : moves) {
                    if(move.endPosition.equals(king.position)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isInCheck(TeamColor teamColor) {
        // get king piece
        // check all squares for pieces of opposite type
        // if opposing team has a piece that can move to king square, king is in check

        ChessPiece king = board.getPiece(ChessPiece.PieceType.KING, teamColor);
        if(king == null) { return false; }

        for(int i=1; i <= 8; i++) {
            for(int j=1; j <= 8; j++) {

                ChessPiece piece = board.getPiece(new ChessPosition(i,j));
                if (piece == null) { continue; }
                if(piece.getTeamColor() == teamColor) { continue; }

                Collection<ChessMove> moves = piece.pieceMoves(board);
                for(ChessMove move : moves) {
                    if(move.endPosition.equals(king.position)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isInCheckmate(TeamColor teamColor) {
        // get king piece
        // check if king is in check
        //  check if moving king exits check
        //  check if moving other pieces resolves check
        //      check if blocks check
        //      check if stops piece from checking

        if (!isInCheck(teamColor)) { return false; }

        for(int i=1; i <= 8; i++) {
            for(int j=1; j <= 8; j++) {

                ChessPiece piece = board.getPiece(new ChessPosition(i,j));
                if (piece == null) { continue; }

                if(piece.getTeamColor() == teamColor) {
                    Collection<ChessMove> moves = validMoves(piece.position);
                    if (!moves.isEmpty()) { return false; }
                }
            }
        }
        return true;
    }

    public boolean isInStalemate(TeamColor teamColor) {
        if (isInCheck(teamColor)) { return false; }

        for(int i=1; i <= 8; i++) {
            for(int j=1; j <= 8; j++) {

                ChessPiece piece = board.getPiece(new ChessPosition(i,j));
                if (piece == null) { continue; }

                if(piece.getTeamColor() == teamColor) {
                    Collection<ChessMove> moves = validMoves(piece.position);
                    if (!moves.isEmpty()) { return false; }
                }
            }
        }
        return true;
    }

    public void setBoard(ChessBoard board) { this.board = board; }

    public ChessBoard getBoard() {
        return board;
    }
}
