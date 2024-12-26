package org.example.chess.pieces;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessPiece;
import org.example.chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
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
        return mat;
    }
}
