package chess;

import java.util.ArrayList;
import java.util.Collection;

public class ChessPiece {

    private final ChessGame.TeamColor pieceColor;
    private final PieceType type;

    public ChessPiece(ChessGame.TeamColor pieceColor, PieceType type) {
        this.pieceColor = pieceColor;
        this.type = type;
    }

    public ChessGame.TeamColor getTeamColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return type;
    }

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        Collection<ChessMove> moves = new ArrayList<>();

        // Movement logic placeholder
        switch (type) {
            case PAWN:
                // TODO: Add pawn moves
                break;
            case ROOK:
                // TODO: Add rook moves
                break;
            case KNIGHT:
                // TODO: Add knight moves
                break;
            case BISHOP:
                // TODO: Add bishop moves
                break;
            case QUEEN:
                // TODO: Add queen moves
                break;
            case KING:
                // TODO: Add king moves
                break;
        }

        return moves;
    }

    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChessPiece)) return false;
        ChessPiece other = (ChessPiece) obj;
        return pieceColor == other.pieceColor && type == other.type;
    }

    @Override
    public int hashCode() {
        return 31 * pieceColor.hashCode() + type.hashCode();
    }

    @Override
    public String toString() {
        return pieceColor.toString().charAt(0) + "-" + type.toString().charAt(0);
    }
}
