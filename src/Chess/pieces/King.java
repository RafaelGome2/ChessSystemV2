package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class King extends ChessPiece{
//-----------------------------------------------------
	public King(Board board, Color color) {
		super(board, color);
	}
	@Override 
	public String toString() {
		return "K";
			}
	
	private boolean canMove(Position position) {//testa a posiçao de destino
		ChessPiece p = (ChessPiece)getBoard().piece(position);
			return p==null || p.getColor()!= getColor();
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
		
		
		
		
		
		return mat;
				
	}

	

}
