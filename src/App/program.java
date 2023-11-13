package App;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class program {
	
	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		List<ChessPiece> captured= new ArrayList<>();
		

		while(!chessMatch.getCheckMate()) {
		try{//tratando as exceçoes
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		System.out.println();
		System.out.print("source: ");//se não tiver peça no source deve lançar exceção
		ChessPosition source = UI.readChessPosition(sc);
		boolean[][] possibleMoves = chessMatch.possibleMoves(source);
		UI.clearScreen();
		UI.printBoard(chessMatch.getPieces(), possibleMoves);
		System.out.println();
		System.out.print("target: ");
		ChessPosition target = UI.readChessPosition(sc);
		//aqui faz o movimento no tabuleiro, agora só falta imprimir
		ChessPiece capturedPiece= chessMatch.performChessMove(source, target);
		if(capturedPiece != null) {//caso capture uma peça add esta peça a lista captured
			captured.add(capturedPiece);
		}
		}
	
	catch (ChessException e) {
		System.out.println(e.getMessage());
		sc.nextLine();
	}
	catch (InputMismatchException e) {
		System.out.println(e.getMessage());
	sc.nextLine();
	}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		
			}
}
	


