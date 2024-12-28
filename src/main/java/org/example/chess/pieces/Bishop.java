package org.example.chess.pieces;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessPiece;
import org.example.chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCols()];
        Position p = new Position(0, 0);

        p.setValues(position.getRow() - 1, position.getCol() -1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow() - 1, p.getCol() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow() -1, position.getCol() +1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow() - 1, p.getCol() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow()+1, position.getCol() + 1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow() + 1, p.getCol() + 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        p.setValues(position.getRow() + 1, position.getCol() -1);
        while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getCol()] = true;
            p.setValues(p.getRow() + 1, p.getCol() - 1);
        }
        if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getCol()] = true;
        }

        return mat;
    }
}
