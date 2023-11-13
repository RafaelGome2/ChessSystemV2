package boardGame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;

//-------------------------------------	
	public Board(int rows, int columns) {
     if(rows <1 || columns <1) {
    	throw new BoardException("error creating board: there must be at least 1 row and 1 column");
     }
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns]; }
		//-------------------------
	

	public int getRows() {
		return rows;
	}	
	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {//caso for !0 ou ~0 significa que position não existe
			throw new BoardException("position not on the board!");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) {
		 throw new BoardException("position not on the board!");		
		}
		
		return pieces[position.getRow()][position.getColumn()];  
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("there is already a piece on position:" +position);
		}
		pieces[position.getRow()][position.getColumn()]= piece;
		piece.position = position; //a position da peça e acessivel diretamente pois é protected
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {//caso a position não existir lança exception
			throw new BoardException ("position not on the board!");
		}
		if(piece(position) == null) {
			return null;
			
			}
		Piece aux = piece(position);// o obj piece é public nesta classe
		aux.position= null;
		pieces[position.getRow()][position.getColumn()]=null;//limpa esta posição na matriz
		return aux; //retorna a peça que foi removida da matriz pieces[][]
	}
	//----------------------funçoes booleanas-----------------
	private boolean positionExists(int row, int column) {//retorna 0 ou 1
		return row>=0 && row <rows && column >=0 && column < columns;
		
	}//reaproveita o método acima
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(),position.getColumn());
	}
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("position not on the board!");
		}
		return piece(position) !=null;
		}
}
	

