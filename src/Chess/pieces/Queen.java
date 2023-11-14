package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardGame.Board;
import boardGame.Position;
  
public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
		// TODO Auto-generated constructor stub
	}
//------------------------------------------------------------------------	
	@Override
	public String toString() {
		return "Q";
		}
	
	@Override
	public boolean[][] possibleMoves() {//aqui define o mat de tamanho[8][8]
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
		
		//above
		p.setValue(position.getRow()-1,position.getColumn());
/*o laço while para quando encontra uma peça e depois faz o teste IF(vrf se tem posiçao e se tem uma peça 
 * oponente) se sim, esta posição recebe true	'*/		
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
		p.setRow(p.getRow()-1);}//dimunui 1 linha da linha atual, para testar a linha acima
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
				}
		
		//below 
		p.setValue(position.getRow()+1, position.getColumn());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()]= true;//marca de true este elemento
			p.setRow(p.getRow()+1);//incrementa 1 linha p/ testar a linha de baixo
		}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca de true este elemento
		}
		//left
		p.setValue(position.getRow(), position.getColumn()-1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
		p.setColumn(p.getColumn()-1);}//diminui 1 coluna, p/ testar a coluna  da esquerda
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;
		}
		//right 
		p.setValue(position.getRow(), position.getColumn()+1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
		mat[p.getRow()][p.getColumn()]=true;
		p.setColumn(p.getColumn()+1);}
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()]=true;//marca de true este elemento da matriz
		}
		
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
