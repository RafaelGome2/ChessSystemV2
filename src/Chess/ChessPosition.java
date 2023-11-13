package Chess;

import boardGame.Position;
/*ChessPosition é uma classe só p/ receber a posição no formato xadrez pelo usuario
e usa a funçao toPosition() p/ um endereço valido na matriz*/ 
public class ChessPosition {
	private char column;
	private int row;
//-----------------------; 
	/*esta classe recebe como arg um char column e um int row e em seguida faz os testes: 
	 'h' <column< 'a'  -->pois as colunas do tabuleiro vão de 'a' até 'h' colunas fora deste
	 intervalo são invalidas
	            OU
	8 <row< 1 -->pois as linhas do tabuleiro vão de 1 a 8, linhas fora deste intervalo são 
	invalidas			
	  
	  e se este teste der positivo lança uma exceção (ChessException)
	 */
	public ChessPosition(char column, int row) { //o tabuleiro vai da linha 1 a 8 e de 'a' ate 'h'
		if(column <'a' || column >'h' || row<1 || row>8) {
			throw new ChessException("Error instantianting ChessPosition. valid values are from a1 to h8.");
					}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}	
	public int getRow() {
		return row;
	}
	// recebe a posição no formato xadrez e retorna a posição na MATRIZ 
	protected Position toPosition(){ 
		return new Position((8-row), (column -'a') );}
	//retorna as posiçoes da matriz no formato xadrez
	protected static ChessPosition fromPosition(Position position) {   
		return new ChessPosition ((char)('a'+ position.getColumn()), 8-position.getRow()); }
	
	@Override 
	public String toString() {
		return "" +column+row;
	}
	
	
	
	
	}