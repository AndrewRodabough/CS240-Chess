package chess.move;

public record PossibleMove(int offsetX, int offsetY, boolean canCapture, boolean canMoveIfEmpty, boolean forFirstMove, boolean canPromote) {

}
