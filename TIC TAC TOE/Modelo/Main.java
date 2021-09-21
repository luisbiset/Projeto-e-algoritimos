package Modelo;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner in = new Scanner(System.in);
		boolean continuar;
		
		
		Tabuleiro tabuleiro = new Tabuleiro();
		
		
		
		
		tabuleiro.mostrar();
		System.out.println("\n");
		
		
		while(continuar = in.nextLine() != "exit") {
			System.out.println("faça sua jogada");
			tabuleiro.jogada(Integer.parseInt(in.nextLine()), 
					Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));
			
			tabuleiro.mostrar();
			
		}
		
			
			
			
		}
		
		
	}


