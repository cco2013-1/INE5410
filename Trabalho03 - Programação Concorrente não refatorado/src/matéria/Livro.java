package matéria;

import java.util.concurrent.locks.ReentrantLock;

public class Livro{
	private int tempoLeitura;
	int vezesQueFoiLido;
	ReentrantLock lock = new ReentrantLock();
	
	public Livro(int tempoLeitura) {
		this.tempoLeitura = tempoLeitura;	
	}
	
	public void ler() {
		lock.lock(); //bloqueia a leitura
		try {
			vezesQueFoiLido++;
			Thread.sleep(this.tempoLeitura*Principal.unidadeTempo);
		} catch (InterruptedException e) {
			System.out.println("Foi interrompido quando etava lendo");
		}finally{
			lock.unlock(); //desbloqueia a leitura
		}
	}
}
