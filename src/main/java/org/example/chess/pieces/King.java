package org.example.chess.pieces;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessMatch;
import org.example.chess.ChessPiece;
import org.example.chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCols()];
        Position p = new Position(0, 0);

        p.setValues(position.getRow() - 1, position.getCol());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow() + 1, position.getCol());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow(), position.getCol() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow(), position.getCol() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow() - 1, position.getCol() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow() - 1, position.getCol() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow() + 1, position.getCol() - 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow() + 1, position.getCol() + 1);
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        // #specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // #specialmove castling kingside rook
            Position posT1 = new Position(position.getRow(), position.getCol() + 3);
            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getCol() + 1);
                Position p2 = new Position(position.getRow(), position.getCol() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getCol() + 2] = true;
                }
            }
            // #specialmove castling queenside rook
            Position posT2 = new Position(position.getRow(), position.getCol() - 4);
            if (testRookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getCol() - 1);
                Position p2 = new Position(position.getRow(), position.getCol() - 2);
                Position p3 = new Position(position.getRow(), position.getCol() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getCol() - 2] = true;
                }
            }
        }

        return mat;
    }
}
