package chess;

/**
 * Represents a single square position on a chess board
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPosition {

    private final int row;
    private final int col;

    public ChessPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
    /**
     * overload for standard chess notation
     */
    public ChessPosition(char row, int col) {
        this.row = row - 65;
        this.col = col - 1;
    }
    /**
     * @return which row this position is in
     * 1 codes for the bottom row
     */
    public int getRow() { return row; }

    /**
     * @return which column this position is in
     * 1 codes for the left row
     */
    public int getColumn() { return col;}

    public ChessPosition add(ChessPosition other) {
        return new ChessPosition(this.getRow() + other.getRow(), this.getColumn() + other.getColumn());
    }

    @Override
    public int hashCode() {
        int hash = row >= col ? row * row + row + col : row + col * col;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ChessPosition)) return false;
        ChessPosition o = (ChessPosition) obj;
        return this.row == o.row && this.col == o.col;
    }

    @Override
    public String toString() {
        String s = "Pos(" + row + "," + col + ")";
        return s;
    }
}
