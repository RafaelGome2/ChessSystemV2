<<<<<<< HEAD
package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class Knight extends ChessPiece {
//-----------------------------------------------------		
	public Knight(Board board, Color color) {
		super(board, color);
	}
//-----------------------------------------------------	
	@Override 
	public String toString() {
		return "N";
			}
	
	private boolean canMove(Position position) {//testa a posiçao de destino
		ChessPiece p = (ChessPiece)getBoard().piece(position);
			return p==null || p.getColor()!= getColor();
//retorna 1 se p==null(ou seja, não tem peça no destino).Ou retorna 1 se no destino tiver peça de cor inimiga			
	}
	@Override
	public boolean[][] possibleMoves() {//nº de linhas e colunas de mat
/*int[][] a = new int[x][y] --> matriz a de tamanho X e Y				*/		
		boolean[][] mat= new boolean[board.getRows()][board.getColumns()];
		Position p = new Position(0, 0);
		
		
		p.setValue(position.getRow()-1, position.getColumn()+2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca esta posição true
		}
		
		p.setValue(position.getRow()-1, position.getColumn()-2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca esta posição true
			}
	
		p.setValue(position.getRow()-2, position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
	
		p.setValue(position.getRow()-2, position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
	
		p.setValue(position.getRow()+1, position.getColumn()-2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		p.setValue(position.getRow()+1, position.getColumn()+2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			}
		
		p.setValue(position.getRow()+2, position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
				}
		
		p.setValue(position.getRow()+2, position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
				return mat;
				
	}

}
=======
package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class Knight extends ChessPiece {
//-----------------------------------------------------		
	public Knight(Board board, Color color) {
		super(board, color);
	}
//-----------------------------------------------------	
	@Override 
	public String toString() {
		return "N";
			}
	
	private boolean canMove(Position position) {//testa a posiçao de destino
		ChessPiece p = (ChessPiece)getBoard().piece(position);
			return p==null || p.getColor()!= getColor();
//retorna 1 se p==null(ou seja, não tem peça no destino).Ou retorna 1 se no destino tiver peça de cor inimiga			
	}
	@Override
	public boolean[][] possibleMoves() {//nº de linhas e colunas de mat
/*int[][] a = new int[x][y] --> matriz a de tamanho X e Y				*/		
		boolean[][] mat= new boolean[board.getRows()][board.getColumns()];
		Position p = new Position(0, 0);
		
		
		p.setValue(position.getRow()-1, position.getColumn()+2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca esta posição true
		}
		
		p.setValue(position.getRow()-1, position.getColumn()-2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca esta posição true
			}
	
		p.setValue(position.getRow()-2, position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
	
		p.setValue(position.getRow()-2, position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
	
		p.setValue(position.getRow()+1, position.getColumn()-2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		
		p.setValue(position.getRow()+1, position.getColumn()+2);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
			}
		
		p.setValue(position.getRow()+2, position.getColumn()-1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()]= true;
				}
		
		p.setValue(position.getRow()+2, position.getColumn()+1);
		if(getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		
		
		
		return mat;
				
	}

}
>>>>>>> bc77d4ff0c095b7eda0227a24d0ed1cb304ac5b5
