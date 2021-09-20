package siul.campoMinado.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	private boolean mined = false;
	private boolean marked = false;
	private boolean opened = false;
	private int row;
	private int col;
	
	List<Campo> fields = new ArrayList<Campo>();
	
	public Campo(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	

	
	boolean addField(Campo vizinho) {
		boolean linhaDiff = row != vizinho.row;
		boolean colunaDiff = col != vizinho.col;
		boolean diagonal = linhaDiff && colunaDiff;
		
	final	int deltaLinha = Math.abs(row - vizinho.row);
	final	int deltaColuna = Math.abs(col - vizinho.col);
		int totalDelta = deltaLinha + deltaColuna;
		
		if(totalDelta == 1 && !diagonal) {
			fields.add(vizinho);
			return true;
		}else if(totalDelta ==2 && diagonal) {
			
			fields.add(vizinho);
			return true;
		} else
			return false;
	}
	
	
	
	
	
	public int getRow() {
		return row;
	}


	

	public int getCol() {
		return col;
	}



boolean arm() {
	return mined = true;
}
	
	
	boolean ismined() {
		return mined;
		
	}
		
	boolean isMarked() {
		return marked;
	}
	
	boolean isOpen() {
		return opened;
	}
	
	boolean isClosed() {
		return !opened;
	}
		
	
	void alterarMarcacao() {
		if(!opened) {
			marked = !marked;
		}
	}
		
	boolean openFields() {
		if(!opened && !marked) {
			opened = true;
			
			if(mined) {
				System.out.println("Você perdeu o jogo =/");
			}
			if(safeZone()) {
				fields.forEach(v -> v.openFields());
			}
			return true;
		} else {
			
			return false;
		}
		
	}
		
	boolean safeZone() {
		return fields.stream().noneMatch(v -> v.mined);
	}
	
	
	boolean fieldGoal() {
		boolean obj1 = !mined && opened;
		boolean obj2 = mined && marked;
		
		
		return obj1 || obj2;
	}
	
	
	long fieldMine() {
		return fields.stream().filter(v -> v.mined).count();
	}
	
	void restart() {
		opened = false;
		mined = false;
		marked = false;
	}
	
	public String toString() {
		if(marked) {
			return "!";
		} else if(opened && mined) {
			return "*";
		} else if(opened && fieldMine()>0) {
			return Long.toString(fieldMine());
		} else if(opened) {
			return " ";
		}else {
			return "?";
			
		}
			
			
			
			
						
	}
		
}


