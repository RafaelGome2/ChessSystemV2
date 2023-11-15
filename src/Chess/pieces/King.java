package Chess.pieces;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class King extends ChessPiece{
//-----------------------------------------------------
	ChessMatch chessMatch ;
	public King(Board board, Color color, ChessMatch chessMatch ) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	@Override 
	public String toString() {
		return "K";
			}
	
	private boolean canMove(Position position) {//testa a posiçao de destino
		ChessPiece p = (ChessPiece)getBoard().piece(position);
			return p==null || p.getColor()!= getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
	return  p !=null && p instanceof Rook && p.getColor()==getColor() && p.getMoveCount()==0; 
//se isto tudo acontecer significa que tenho uma torre na posição argumentada e ela está apta para Roque	
	
	}
	
		
	@Override
	public boolean[][] possibleMoves() {//nº de linhas e colunas de mat
/*int[][] a = new int[x][y] --> matriz a de tamanho X e Y				*/		
		boolean[][] mat= new boolean[board.getRows()][board.getColumns()];
		Position p = new Position(0, 0);
		
		//ABOVE
		p.setValue(position.getRow()-1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca esta posição true
		}
		//BELOW
		p.setValue(position.getRow()+1, position.getColumn());
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca esta posição true
			}
		//LEFT
		p.setValue(position.getRow(), position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//RIGHT
		p.setValue(position.getRow(), position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		//NO
		p.setValue(position.getRow()-1, position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//NE
		p.setValue(position.getRow()-1, position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			}
		// SO
		p.setValue(position.getRow()+1, position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
				}
		// SE
		p.setValue(position.getRow()+1, position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//#ESPECIALMOVE CASTLING 
		//SE for o primeiro movimento do rei e se este não estiver em check
		if(getMoveCount()==0 && !chessMatch.getCheck()) {
			//special move kingside rook--->        ROQUE PEQUENO
			Position posT1 = new Position(position.getRow(), position.getColumn()+3);
			if(testRookCastling(posT1)) {
//p1 é a posição a direita do King e p2 é a 2 posiçoes a direita após a posição do King				
			Position p1 = new Position(position.getRow(), position.getColumn()+1);
			Position p2 = new Position(position.getRow(), position.getColumn()+2);
//testa se não tem peças entre o King e Rook, testa as duas posiçoes			
			if(getBoard().piece(p1)==null && getBoard().piece(p2)==null) {
			 mat[position.getRow()][position.getColumn()+2]	= true;
			}
			}
			//ROQUE GRANDE, posT2 é a posição da Rook a esquerda do Rei
			Position posT2 = new Position(position.getRow(), position.getColumn()-4);
			if(testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn()-1);
				Position p2 = new Position(position.getRow(), position.getColumn()-2);
				Position p3 = new Position(position.getRow(), position.getColumn()-3);
//testa se não tem peças entre o King e a Rook da esquerda
				if(getBoard().piece(p1)==null && getBoard().piece(p2)==null && getBoard().piece(p3)==null) {
					 mat[position.getRow()][position.getColumn()-2]	= true;
					}
			}
		}
		
		
		
		return mat;
				
	}

	

}
