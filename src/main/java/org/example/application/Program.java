package org.example.application;

import org.example.boardgame.Board;
import org.example.boardgame.Position;
import org.example.chess.ChessException;
import org.example.chess.ChessMatch;
import org.example.chess.ChessPiece;
import org.example.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner scanner = new Scanner(System.in);
        List<ChessPiece> captured = new ArrayList<ChessPiece>();
        while(true){
            try{
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(scanner);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Destination: ");
                ChessPosition destination = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, destination);

                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                scanner.nextLine();
            }


        }

    }
}
