package boardGame;

public abstract class Piece {
	protected Position position;
	protected Board board;
	//--------------------------------------------	
		public Piece(Board board) {
				this.board = board;
				position = null;
		}
		Piece(){}
	//---------------------------------------------	
		protected Board getBoard() {
			return board;
		}
	//metodo generico, abstrato. retorna uma matriz boolean
		public abstract boolean[][] possibleMoves();
	//esta funçao faz um retorno booleano da posiçao argumentada, retorna FALSE ou TRUE	
		public boolean possibleMove(Position position){
			return possibleMoves()[position.getRow()][position.getColumn()];
		}
		public boolean isTheAnyPossibleMove() {
			boolean[][] mat = possibleMoves();
			for(int i=0;i<mat.length;i++) {
				for(int j=0;j<mat.length;j++) {
				if(mat[i][j]) {//se o elemtendo [i][j] for verdadeiro 
					return true;
				}
				}
				}
				return false;
				}
		
}
