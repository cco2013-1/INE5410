package universidade;

public class Livro {
	private int identificador;
	private int tempoLeitura;
	
	public Livro(int identificador, int tempoLeitura) {
		this.identificador = identificador;
		this.tempoLeitura = tempoLeitura;	
	}
	
	public synchronized void ler() {
		
	}
}
