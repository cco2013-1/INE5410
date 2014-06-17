package materia;

import java.util.concurrent.locks.ReentrantLock;

public class Livro{
	private int tempoLeitura;
	private int vezesQueFoiLido;
	ReentrantLock lock = new ReentrantLock();
	
	public Livro(int tempoLeitura) {
		this.tempoLeitura = tempoLeitura; 
		this.vezesQueFoiLido = 0;
	}
	
	public void ler() {
		lock.lock(); //bloqueia a leitura
		try {
			this.vezesQueFoiLido++; 
			Thread.sleep(this.tempoLeitura*Principal.unidadeTempo);
		} catch (InterruptedException e) {
			System.out.println("Foi interrompido quando etava lendo");
		}finally{
			lock.unlock(); //desbloqueia a leitura
		}
	}
	
	public int vezesQueFoiLido() { //retorna o numero de vezes que o livro foi lido
		return this.vezesQueFoiLido;
	}
}
