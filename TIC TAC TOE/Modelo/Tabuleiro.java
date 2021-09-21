package Modelo;

import java.util.Iterator;

class Tabuleiro {
	
	private int[][] tabuleiro = new int[3][3];
	
	private boolean marcado = false;
	
	
	
	
	public Tabuleiro() {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0;j < 3; j++) {
				tabuleiro[i][j] = 0;
			}
			
		}
	}
	
	
	
		
			
	public void mostrar() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0;j < 3; j++) {
				System.out.print(tabuleiro[i][j]+" ");
	}
			System.out.println(" ");
			
		}
		
	}
	
	
	public boolean jogada(int jogador, int linha, int coluna ) {
		
		if(linha < 0) {
			return false;
			
		}else if(linha > 2) {
			return false;
			
		}else if(coluna <0) {
			return false;
		}else if(coluna >2) {
			return false;
		}else {
		 tabuleiro[linha][coluna] = jogador;
		 return true;
			
		} 
			
		
			
			
		}
	}
		
		
		
		
		
		 
		
		
		
							
			
			
			
			
	


	
	
	


	
