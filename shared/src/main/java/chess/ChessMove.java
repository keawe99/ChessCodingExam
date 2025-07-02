package chess;

/**
 * Represents moving a chess piece on a chessboard.
 * You can add to this class, but you may not alter
 * the signature of the existing methods.
 */
public class ChessMove {
    private final ChessPosition startPosition;
    private final ChessPosition endPosition;
    private final ChessPiece.PieceType promotionPiece;

    /**
     * Constructor for a chess move.
     *
     * @param startPosition   starting position of the move
     * @param endPosition     ending position of the move
     * @param promotionPiece  optional promotion piece type (can be null)
     */
    public ChessMove(ChessPosition startPosition, ChessPosition endPosition,
                     ChessPiece.PieceType promotionPiece) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.promotionPiece = promotionPiece;
    }

    /**
     * @return ChessPosition of starting location
     */
    public ChessPosition getStartPosition() {
        return startPosition;
    }

    /**
     * @return ChessPosition of ending location
     */
    public ChessPosition getEndPosition() {
        return endPosition;
    }

    /**
     * Gets the type of piece to promote a pawn to if pawn promotion is part of this move.
     *
     * @return Type of piece to promote a pawn to, or null if no promotion
     */
    public ChessPiece.PieceType getPromotionPiece() {
        return promotionPiece;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChessMove)) return false;
        ChessMove other = (ChessMove) obj;
        return startPosition.equals(other.startPosition) &&
                endPosition.equals(other.endPosition) &&
                ((promotionPiece == null && other.promotionPiece == null) ||
                        (promotionPiece != null && promotionPiece.equals(other.promotionPiece)));
    }

    @Override
    public int hashCode() {
        int result = startPosition.hashCode();
        result = 31 * result + endPosition.hashCode();
        result = 31 * result + (promotionPiece != null ? promotionPiece.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s%s",
                startPosition, endPosition,
                promotionPiece != null ? " (promote to " + promotionPiece + ")" : "");
    }
}
