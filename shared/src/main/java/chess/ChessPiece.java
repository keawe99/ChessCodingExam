package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        List<ChessMove> moves = new ArrayList<>();

        switch (type) {
            case ROOK -> generateLinearMoves(board, moves, myPosition, new int[][]{
                    {1, 0}, {-1, 0}, {0, 1}, {0, -1}
            });
            case BISHOP -> generateLinearMoves(board, moves, myPosition, new int[][]{
                    {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
            });
            case QUEEN -> generateLinearMoves(board, moves, myPosition, new int[][]{
                    {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                    {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
            });
            case KING -> generateStepMoves(board, moves, myPosition, new int[][]{
                    {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                    {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
            });
            case KNIGHT -> generateStepMoves(board, moves, myPosition, new int[][]{
                    {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                    {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
            });
            case PAWN -> {
                // We'll add pawn logic after this if you want
            }
        }

        return moves;
    }

    private void generateLinearMoves(ChessBoard board, List<ChessMove> moves,
                                     ChessPosition from, int[][] directions) {
        for (int[] dir : directions) {
            int row = from.getRow();
            int col = from.getColumn();

            while (true) {
                row += dir[0];
                col += dir[1];

                if (!isInBounds(row, col)) break;

                ChessPosition to = new ChessPosition(row, col);
                ChessPiece target = board.getPiece(to);

                if (target == null) {
                    moves.add(new ChessMove(from, to, null));
                } else {
                    if (target.getTeamColor() != this.pieceColor) {
                        moves.add(new ChessMove(from, to, null));
                    }
                    break;
                }
            }
        }
    }

    private void generateStepMoves(ChessBoard board, List<ChessMove> moves,
                                   ChessPosition from, int[][] directions) {
        for (int[] dir : directions) {
            int row = from.getRow() + dir[0];
            int col = from.getColumn() + dir[1];

            if (isInBounds(row, col)) {
                ChessPosition to = new ChessPosition(row, col);
                ChessPiece target = board.getPiece(to);

                if (target == null || target.getTeamColor() != this.pieceColor) {
                    moves.add(new ChessMove(from, to, null));
                }
            }
        }
    }

    private boolean isInBounds(int row, int col) {
        return row >= 1 && row <= 8 && col >= 1 && col <= 8;
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
