
package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;

public class Bishop extends ChessPiece{
	public Bishop(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		 boolean[][] mat= new boolean[getBoard().getRows()][getBoard().getColumns()];
		 Position p = new Position(0,0);
		 
		 //sobe diagonal esquerda
			p.setValue(position.getRow()-1,position.getColumn()-1);
	/*o laço while para quando encontra uma peça e depois faz o teste IF(vrf se tem posiçao e se tem uma peça 
	 * oponente) se sim, esta posição recebe true	'*/		
			while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setValue(p.getRow()-1, p.getColumn()-1);}
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()]=true;
					}
			
			//sobe diagonal direita
			p.setValue(position.getRow()-1, position.getColumn()+1);
			while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()]= true;//marca de true este elemento
				p.setValue(p.getRow()-1, p.getColumn()+1);
			}
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()]=true;//marca de true este elemento
			}
			//desce diagonal esquerda
			p.setValue(position.getRow()+1, position.getColumn()-1);
			while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setValue(p.getRow()+1, p.getColumn()-1);}
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()]=true;
			}
			//desce diagonal direita
			p.setValue(position.getRow()+1, position.getColumn()+1);
			while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
			p.setValue(p.getRow()+1, p.getColumn()+1);}
			if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()]=true;//marca de true este elemento da matriz
			}
			
		return mat;
		}
	}
			






