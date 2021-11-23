package letras.Algoritimo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main extends Musica {
	
	public static void main(String[] args) {
		
		
		
		
		// Instanciando o objeto de base e o scanner para receber a entrada do usu�rio.
		
		Musica base = new Musica();
		
		Scanner in = new Scanner(System.in);
				
		
		// a string de entrada ser� divida em palavras para fazer as compara��es.		
		
		
		System.out.print("# "+"Digite sua Busca:");
		
		String entrada = in.nextLine();
		System.out.println("#");			
		
		final String[] palavrasEntrada = entrada.split(" ");
		
		final List<Musica> top10 = new ArrayList<Musica>();
		
		
		in.close();
		
		
		
		
		// o primeiro la�o for percorrer� a lista de musicas e dividir� cada musica do array em palavras.
		
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
			 *  o segundo la�o  percorrer� a lista de palavras de uma musica e aplicar� o metodo
			 *  normalize para formatar todas as palavras da musica e ignorar a acentua��o nas compara��es
			 */
			
			for( int b = 0; b < musica.length; b++) {				
										
				musica[b] = Normalizer.normalize(musica[b],Normalizer.Form.NFD).toLowerCase();
				musica[b] = musica[b].replaceAll("[^\\p{ASCII}]", "");
				
				
				/*
				 *  o terceiro la�o for vai percorrer a lista de palavras da entrada e aplicar�
				 *  o metodo normalize em todas as palavras da entrada.
				 */
				
					for(int c = 0; c < palavrasEntrada.length; c++) {					
					 
						palavrasEntrada[c] = Normalizer.normalize(palavrasEntrada[c],Normalizer.Form.NFD).toLowerCase();
						palavrasEntrada[c] = palavrasEntrada[c].replaceAll("[^\\p{ASCII}]", "");
										
						if (palavrasEntrada[c].equalsIgnoreCase(musica[b])) {
							scoreWord += 10;
						} 					
					
					/*
					 * A vari�vel wordLenght foi criada com o prop�sito de igualar o tamanho das palavras,
					 * adicionando no la�o, o menor tamanho de palavras, para o array n�o percorrer
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
					
			
			
				// Calculando o Score da m�sica e adicionando na lista de top10
				
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
	

	

		
		
	
					
			
			
			
				
						
						
											
						
							
								
								
			
		
	
	

			
			
						 
																												
		
							 
						
					
					
	

			
			
			
			
			
			
		
				
				
		
	

			
				
							
				
		
	
	
				
			
	
	


