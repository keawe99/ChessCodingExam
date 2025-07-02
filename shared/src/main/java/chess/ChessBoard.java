package chess;

import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private final Map<ChessPosition, ChessPiece> board;

    public ChessBoard() {
        board = new HashMap<>();
    }

    public void addPiece(ChessPosition position, ChessPiece piece) {
        board.put(position, piece);
    }

    public ChessPiece getPiece(ChessPosition position) {
        return board.get(position);
    }

    public void resetBoard() {
        board.clear();
        ChessGame.TeamColor white = ChessGame.TeamColor.WHITE;
        ChessGame.TeamColor black = ChessGame.TeamColor.BLACK;

        // Pawns
        for (int col = 1; col <= 8; col++) {
            addPiece(new ChessPosition(2, col), new ChessPiece(white, ChessPiece.PieceType.PAWN));
            addPiece(new ChessPosition(7, col), new ChessPiece(black, ChessPiece.PieceType.PAWN));
        }

        // Rooks
        addPiece(new ChessPosition(1, 1), new ChessPiece(white, ChessPiece.PieceType.ROOK));
        addPiece(new ChessPosition(1, 8), new ChessPiece(white, ChessPiece.PieceType.ROOK));
        addPiece(new ChessPosition(8, 1), new ChessPiece(black, ChessPiece.PieceType.ROOK));
        addPiece(new ChessPosition(8, 8), new ChessPiece(black, ChessPiece.PieceType.ROOK));

        // Knights
        addPiece(new ChessPosition(1, 2), new ChessPiece(white, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(1, 7), new ChessPiece(white, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(8, 2), new ChessPiece(black, ChessPiece.PieceType.KNIGHT));
        addPiece(new ChessPosition(8, 7), new ChessPiece(black, ChessPiece.PieceType.KNIGHT));

        // Bishops
        addPiece(new ChessPosition(1, 3), new ChessPiece(white, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(1, 6), new ChessPiece(white, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(8, 3), new ChessPiece(black, ChessPiece.PieceType.BISHOP));
        addPiece(new ChessPosition(8, 6), new ChessPiece(black, ChessPiece.PieceType.BISHOP));

        // Queens
        addPiece(new ChessPosition(1, 4), new ChessPiece(white, ChessPiece.PieceType.QUEEN));
        addPiece(new ChessPosition(8, 4), new ChessPiece(black, ChessPiece.PieceType.QUEEN));

        // Kings
        addPiece(new ChessPosition(1, 5), new ChessPiece(white, ChessPiece.PieceType.KING));
        addPiece(new ChessPosition(8, 5), new ChessPiece(black, ChessPiece.PieceType.KING));
    }

    // Optional: For testing and debugging
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 8; row >= 1; row--) {
            sb.append(row).append(" ");
            for (int col = 1; col <= 8; col++) {
                ChessPiece piece = getPiece(new ChessPosition(row, col));
                sb.append(piece != null ? piece.toString() : ".").append(" ");
            }
            sb.append("\n");
        }
        sb.append("  a b c d e f g h");
        return sb.toString();
        //steven armstrong
    }
}
