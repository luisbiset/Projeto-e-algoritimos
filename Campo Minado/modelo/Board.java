package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Board {
	
	private int row;
	private int col;
	private int mines;
	
	private List<Campo> board = new ArrayList<Campo>();

	public Board(int row, int col, int mines) {
		this.row = row;
		this.col = col;
		this.mines = mines;
		
		createfields();
		createvizinhos();
		sortmines();
	}
	
	
	// verificar em caso de erro
	public void open(int row, int col){
		board.parallelStream()
		.filter(c -> c.getRow() == row && c.getCol() == col)
		.findFirst()
		.ifPresent(c -> c.openFields());
		
	}
	
	public void toMark(int row, int col){
		board.parallelStream()
		.filter(c -> c.getRow() == row && c.getCol() == col)
		.findFirst()
		.ifPresent(c -> c.alterarMarcacao());
	}
	

	private void createfields() {
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				board.add(new Campo(r, c));
			}
		}
	}
		
		
		
		
	
	private void createvizinhos() {
		for(Campo c1:board) {
			for( Campo c2: board) {
				c1.addField(c2);
				
			}
		}
	}
	
	private void sortmines() {
		long minesOn = 0;
		Predicate<Campo> mined = f -> f.ismined();
		
		do {
			
			minesOn = board.stream().filter(mined).count();
			int rand0m = (int) (Math.random() * board.size());
			board.get(rand0m).arm();
			
		} while(minesOn < mines);
		
	}
			

	public boolean gameGoal() {
		return board.stream().allMatch(c -> c.fieldGoal());
		
	}
		
	public void restartGame() {
		board.forEach(c -> c.restart());
		sortmines();
	}

	public void mostar() {
		for(int i = 0; i< row;i++) {
			int k = 0;
			k++;
			for(int j = 0; j< col; j++) {
				System.out.print(board.get(k)+" ");
			
		
	
			}
			System.out.println(" ");
		}
		
	}
		
	
		
		
	}
	
	


