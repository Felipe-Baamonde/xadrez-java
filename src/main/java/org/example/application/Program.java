package org.example.application;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessMatch;
import org.example.chess.ChessPiece;
import org.example.chess.ChessPosition;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner scanner = new Scanner(System.in);
        while(true){
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosition(scanner);
            System.out.println();
            System.out.print("Destination: ");
            ChessPosition destination = UI.readChessPosition(scanner);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, destination);
        }

    }
}
