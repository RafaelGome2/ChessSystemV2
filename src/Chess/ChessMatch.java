package Chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.print.attribute.standard.PrinterMakeAndModel;

import Chess.pieces.Bishop;
import Chess.pieces.King;
import Chess.pieces.Knight;
import Chess.pieces.Pawn;
import Chess.pieces.Rook;
import boardGame.Board;
import boardGame.BoardException;
import boardGame.Piece;
import boardGame.Position;
//				 partida de xadrez
public class ChessMatch {
	private Board board;
	private int turn;
	private Color currentyPlayer;
	private List<Piece> piecesOnTheBoard =new ArrayList<>();
	private List<Piece> capturedPieces =new ArrayList<>();
	private boolean check;
	private boolean checkMate;
		//------------------ construtor padrão -------------
	public ChessMatch() {
		board = new Board(8, 8);//cria um tabuleiro 8x8
		turn =1;
		currentyPlayer = Color.WHITE;
		initialSetup();
		}
//---------------------------
	public int getTurn() {
		return turn;
	}
	public Color getCurrentyPlayer() {
		return currentyPlayer;
	}
	public boolean getCheck() {
		return check;
	}
		
	public boolean getCheckMate() {
		return checkMate;
	}
	// funçao getPiece(), ela retorna um result do tipo ChessPiece[][]	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows();i++) {
			for(int j=0;j<board.getColumns();j++) {
				mat[i][j] = (ChessPiece)board.piece(i, j);			}
		
		}
	return mat;//retorna uma matriz 
	}
	
	
	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();//transforma em posição de matriz
		validateSourcePosition(position);
		return board.piece(position).possibleMoves(); 
	}
	public ChessPiece performChessMove(ChessPosition sourcePosition,ChessPosition targetPosition)
	{	Position source = sourcePosition.toPosition();//transforma posição xadrez em posiçao matriz
		Position target= targetPosition.toPosition();
		validateSourcePosition(source);//faz teste e se der erro lança exceçao
		validateTargetPosition(source,target);
		Piece capturedPiece = makeMove(source, target);
		if(testCheck(currentyPlayer)) {
		undoMove(source, target, capturedPiece);
		throw new ChessException("You can't put yourself in check!");
		}
		check =(testCheck(opponent(currentyPlayer))) ? true : false;
		if(testCheckMate(opponent(currentyPlayer))) {
			checkMate = true;
		}
		else {
		nextTurn();}
		return (ChessPiece) capturedPiece;
		
		}//ChessPiece eh subclasse de Piece
//---------funçoes private------------------------------	
	private Piece makeMove(Position source, Position target) {
		ChessPiece p = (ChessPiece)board.removePiece(source);
		p.increaseMoveCount();
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		if(capturedPiece !=null) {
			piecesOnTheBoard.remove(capturedPiece);//remove na list a peça
			capturedPieces.add(capturedPiece);//add na list a peça
		}
		return capturedPiece;
	}
	
	private void undoMove(Position source, Position target, Piece capturedPiece) {
		ChessPiece p = (ChessPiece) board.removePiece(target);
		p.decreaseMoveCount();
		board.placePiece(p, source); 
		if (capturedPiece !=null) {
			board.placePiece(capturedPiece, target);
		capturedPieces.remove(capturedPiece);
		piecesOnTheBoard.add(capturedPiece);
		}
	}
	
//				sub funçoes privadas 	
	private void validateSourcePosition(Position position) {
//não pode mover a peça do inimigo		
		
		if(!board.thereIsAPiece(position)) {
			throw new ChessException("There is no piece on source position");
		}		
		if(!board.piece(position).isTheAnyPossibleMove()) {
					throw new ChessException("There is no possible moves for the chosen piece");
		}
		if(currentyPlayer != ((ChessPiece)board.piece(position)).getColor()) {
			throw new ChessException("Is Not possible move counter part");
		}
	}
	private void validateTargetPosition(Position source,Position target) {
		if(!board.piece(source).possibleMove(target)) {
			throw new ChessException("The chosen piece can't move to target position");
		}
	}
//caso não houver peça na position source lança Exception	
	private void validateSourcePosition2(Position position) {
		if(board.piece(position)==null) {
			throw new ChessException("There is no piece on source position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentyPlayer = (currentyPlayer == Color.WHITE) ? Color.BLACK: Color.WHITE;
	}
	/*funçao para add uma piece na matriz board*/
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	piecesOnTheBoard.add(piece);
		}
//retorna a COR openente a cor inserida no argumento	
	private Color opponent(Color color) {
		return (color==color.WHITE)? color.BLACK: color.WHITE;
			}
	private ChessPiece king(Color color) {
		List<Piece> list=piecesOnTheBoard.stream().filter(x->((ChessPiece)x).getColor()==color).collect(Collectors.toList());
		for (int i=0; i< list.size(); i ++) {
			Piece p = list.get(i);
			if(p instanceof King) {//caso p for um obj do tipo King 
				return (ChessPiece)p;//retorna p, ou seja, retorna o Rei
			}
		}
		throw new IllegalStateException("There is no"+color+"on the board");
	}
	
	private boolean testCheck(Color color) {
		Position kingPosition = king(color).getChessPosition().toPosition();
/*acessa a lista piecesOnTheBoard vrf se a cor de cada elemento é diferente da cor argumentada 
 * no metodo,ou seja, é uma cor oponente, SE SIM adiciona este elemento na lista opponentPieces */		
		List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x->((ChessPiece)x).getColor()==opponent(color)).collect(Collectors.toList());
		for(int i=0;i<opponentPieces.size();i++) {
			Piece p = opponentPieces.get(i);
			boolean[][] mat = p.possibleMoves();
			if(mat[kingPosition.getRow()][kingPosition.getColumn()])
			{return true;
						}
			}
	return false;
	}
	
	private boolean testCheckMate(Color color) {
		if(!testCheck(color)) {//testa inicialmente se existe um check, senão retorna false
			return false;
		}
		List<Piece> list = piecesOnTheBoard.stream().filter(x->((ChessPiece)x).getColor()==color).collect(Collectors.toList());
		for(Piece p:list) {
			boolean mat[][]=p.possibleMoves();
			for(int i=0; i<board.getRows();i++) {
				for(int j=0;j<board.getColumns(); j++) {
				if (mat[i][j]) {	
					Position source = ((ChessPiece)p).getChessPosition().toPosition();
					Position target= new Position(i, j);
					Piece capturedPiece = makeMove(source, target);
					boolean testCheck = testCheck(color);
					undoMove(source, target, capturedPiece);
					if(!testCheck) {//se não está em check é pq o Rei conseguiu sair do check
						return false;
					}
				}
				}
			}
			}
		return true;
		}
	private void initialSetup() {
		placeNewPiece('b', 1, new Knight(board, Color.WHITE));
		placeNewPiece('g', 1, new Knight(board, Color.WHITE));
	    placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new King(board, Color.WHITE));
        placeNewPiece('h', 1, new Rook(board, Color.WHITE));
        placeNewPiece('a', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('f', 1, new Bishop(board, Color.WHITE));
        placeNewPiece('b', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('c', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('d', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('e', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('f', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('g', 2, new Pawn(board, Color.WHITE));
        placeNewPiece('h', 2, new Pawn(board, Color.WHITE));
        
        placeNewPiece('g', 8, new Knight(board, Color.BLACK));
        placeNewPiece('b', 8, new Knight(board, Color.BLACK));
        placeNewPiece('c', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('f', 8, new Bishop(board, Color.BLACK));
        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new King(board, Color.BLACK));
        placeNewPiece('h', 8, new Rook(board, Color.BLACK));
        placeNewPiece('a', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('b', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('c', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('d', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('e', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('f', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('g', 7, new Pawn(board, Color.BLACK));
        placeNewPiece('h', 7, new Pawn(board, Color.BLACK));
	}
	
}
