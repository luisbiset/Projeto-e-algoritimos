import model.Tabuleiro;
import view.TabuleiroConsole;

public class IniciarJogo {
	
public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		new TabuleiroConsole(tabuleiro);

}
}
