package letras.Algoritimo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main extends Musica {
	
	public static void main(String[] args) {
		
		
		
		
		// Instanciando o objeto de base e o scanner para receber a entrada do usuário.
		
		Musica base = new Musica();
		
		Scanner in = new Scanner(System.in);
				
		
		// a string de entrada será divida em palavras para fazer as comparações.		
		
		
		System.out.print("# "+"Digite sua Busca:");
		
		String entrada = in.nextLine();
		System.out.println("#");			
		
		final String[] palavrasEntrada = entrada.split(" ");
		
		final List<Musica> top10 = new ArrayList<Musica>();
		
		
		in.close();
		
		
		
		
		// o primeiro laço for percorrerá a lista de musicas e dividirá cada musica do array em palavras.
		
		for(int a = 0; a < base.getBase().length;a++) {
			
			String[] musica = base.getBase()[a].split(" ");			
						
			int scoreWord = 0;
			int scoreChar = 0;
			int feat = 0;
			int wordLenght;
						
		
			if(!entrada.contains("feat")  && base.getBase()[a].contains("feat")) {
				feat= 5;
			}						
			
			/*
			 *  o segundo laço  percorrerá a lista de palavras de uma musica e aplicará o metodo
			 *  normalize para formatar todas as palavras da musica e ignorar a acentuação nas comparações
			 */
			
			for( int b = 0; b < musica.length; b++) {				
										
				musica[b] = Normalizer.normalize(musica[b],Normalizer.Form.NFD).toLowerCase();
				musica[b] = musica[b].replaceAll("[^\\p{ASCII}]", "");
				
				
				/*
				 *  o terceiro laço for vai percorrer a lista de palavras da entrada e aplicará
				 *  o metodo normalize em todas as palavras da entrada.
				 */
				
					for(int c = 0; c < palavrasEntrada.length; c++) {					
					 
						palavrasEntrada[c] = Normalizer.normalize(palavrasEntrada[c],Normalizer.Form.NFD).toLowerCase();
						palavrasEntrada[c] = palavrasEntrada[c].replaceAll("[^\\p{ASCII}]", "");
										
						if (palavrasEntrada[c].equalsIgnoreCase(musica[b])) {
							scoreWord += 10;
						} 					
					
					/*
					 * A variável wordLenght foi criada com o propósito de igualar o tamanho das palavras,
					 * adicionando no laço, o menor tamanho de palavras, para o array não percorrer
					 * no vazio ao comparar as letras.
					 *
					 */
										
						wordLenght = Math.min(palavrasEntrada[c].length(), musica[b].length());
										
										
							for( int d = 0; d < wordLenght; d++) {
											
								if(palavrasEntrada[c].charAt(d) == musica[b].charAt(d)) {
										scoreChar+= 1;													
								}
							}
					    }		
			        }				
					
			
			
				// Calculando o Score da música e adicionando na lista de top10
				
				final int score = (scoreChar + scoreWord) - feat;
								
						
				Musica m1 = new Musica(base.getBase()[a], score);
						
				top10.add(m1);
						
		}				
		
		
				// Ordenando e imprimindo o top 10:
		
				
				Collections.sort(top10);					
				
				System.out.println("# " + "Resultados: ");			
				
				
				for(int z = 0; z < 10; z++) {
					
					if(top10.get(z).getPontos() > 0) {						
					System.out.println("# "+ top10.get(z).getPontos()+" pontos, "+ top10.get(z).getNome());
					} else {
						System.out.println("# " + "Sem Resultados");
						}
						
					}
		
					System.out.print("#" + "\n# ------------------------------------------------");
		
		}		
		
	}
	

	

		
		
	
					
			
			
			
				
						
						
											
						
							
								
								
			
		
	
	

			
			
						 
																												
		
							 
						
					
					
	

			
			
			
			
			
			
		
				
				
		
	

			
				
							
				
		
	
	
				
			
	
	


