package letras.Algoritimo;


/*
 * A classe musica cont�m a base de dados e todos os metodos get, al�m de ter implementado o Comparable
 * para ordenar a lista.
 */
public class Musica implements Comparable <Musica> {
	
	 private String nome;
	 private int pontos;
	 
	 
	 final private String[]base = {"Que Tiro Foi Esse", "Deixe-me Ir", "Sobre N�s (Poesia Ac�stica #2)", "Apelido Carinhoso", "T�"
			+" Com Moral No C�u", "Lugar Secreto", "J�", "Perfect", "Fica Tranquilo", "Capricorniana (Poesia"
					+" Ac�stica #3)", "Amor da Sua Cama", "Nessas Horas", "Downtown (part. J Balvin)", "Voc� Vai"
					+" Entender", "Aquieta Minh'alma", "Havana", "Havana feat Young Thug", "Vai Malandra (part. MC"
					+" Zaac, Maejor, Tropkillaz e DJ Yuri Martins)", "Prioridade", "Trevo (Tu) (part. Tiago Iorc)",
					"Machika (part. Anitta y Jeon)", "Trem Bala", "Mo�a do Espelho", "Safad�metro", "Eu Cuido de"
					+"Ti", "Too Good At Goodbyes", "Duro Igual Concreto", "Aquela Pessoa", "Rap Lord (part. Jonas"
					+" Bento)", "Contrato", "IDGAF", "De Quem � a Culpa?", "N�o Troco", "Quase", "Deus � Deus",
					"Anti-Amor", "Eu Era", "Cerveja de Garrafa (Fuma�a Que Eu Fa�o)", "N�o Deixo N�o",
					"Rockstar feat 21 Savage", "New Rules", "Photograph", "Eu Juro", "Ningu�m Explica Deus (part."
					+" Gabriela Rocha)", "Lindo �s", "Bengala e Croch�", "Pirata e Tesouro", "A Libertina", "Pesad�o"
					+" (part. Marcelo Falc�o)", "Aleluia (part. Michely Manuely)", "Eu Cuido de Ti", "Oi", "C�u Azul",
					"Never Be The Same", "My Life Is Going On", "Imaturo", "Gucci Gang", "Cuidado", "K.O.",
					"�chame La Culpa", "�chame La Culpa feat Luis Fonsi", "Tem Caf� (part. MC Hariel)",
					"Raridade", "Te Vi Na Rua Ontem", "Dona Maria (feat Jorge)", "Fica (part. Matheus e Kauan)",
					"9 Meses (Ora��o do Beb�)", "Muleque de Vila", "A Vit�ria Chegou", "Ar Condicionado No 15",
					"Vida Loka Tamb�m Ama", "Pegada Que Desgrama", "Transplante (part. Bruno & Marrone)",
					"Na Conta da Loucura", "Tem Caf� (part. Gaab)", "Apelido Carinhoso", "Perfect Duet", "Perfect"
					+" Duet feat Beyonc�", "Cora��o de A�o", "Minha Morada", "Amar, Amei", "Regime Fechado", "O"
					+" Escudo", "Minha Namorada", "Quero Conhecer Jesus (O Meu Amado � o Mais Belo)", "Me"
					+" Leva Pra Casa", "Como � Que Faz? (part. Rob Nunes)", "The Scientist", "Bella Ciao", "O Que"
					+" Tiver Que Ser Vai Ser", "Corpo Sensual (part. Mateus Carrilho)", "Cor de Marte", "Bom Rapaz"
					+" (part. Jorge e Mateus)", "Vidinha de Balada", "N�o Era Voc�", "Em Teus Bra�os", "De Tr�s Pra"
					+" Frente", "All Of Me", "Believer", "A M�sica Mais Triste do Ano", "Rabiola", "Para�so (part. Pabllo"
					+" Vittar)", "Vem Pra Minha Vida"};
			
			
	
	
		Musica() {}
		
	
	 public String[] getBase() {
		return base;
	}		
	 
	
	 Musica(String nome, int pontos) {
		super();
		this.nome = nome;
		this.pontos = pontos;
	}
	
	
	public String getNome() {
		
		return nome;
	}
	

	public int getPontos() {
		
		return pontos;
	}	
		

	@Override
	public int compareTo(Musica musica) {
		if(this.pontos > musica.pontos) {
			return -1;
		}else if(this.pontos < musica.pontos) {
			return 1;
		}
		
		return this.nome.compareToIgnoreCase(musica.nome);
			
	}

	


	


	
	
	
	

}
