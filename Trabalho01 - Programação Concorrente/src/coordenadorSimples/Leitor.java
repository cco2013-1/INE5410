package coordenadorSimples;

import java.util.concurrent.Future;

public class Leitor extends Thread {
	private Buffer buffer;
	private Coordenador coordenador;
	private boolean concluido;
	private Future f;

	public Leitor (Coordenador coordenador, Buffer buffer, String nome){
		super(nome);
		this.coordenador = coordenador;
		this.buffer = buffer;
		this.concluido = false;
	}
	
	public void recebeFuture(Future f) {
		this.f = f;
	}
	
	public void run(){
		while(!concluido) {
			if(this.buffer.posicaoOcupada() != -1){
				this.ler();
				this.concluido = true;
				this.coordenador.bufferNaoCheio();
				System.out.println("===========================> "+this.getName()+" chegou ao fim!");	
			} else {
				try {
					System.out.println(this.getName()+" foi dormir");
					sleep(6000);
				}catch(Exception e) {
					System.out.println(this.getName()+" foi interrompido");
				}
			}
		}
	}

	public void ler() {
		int numeroLido = this.buffer.ler(this.buffer.posicaoOcupada());
		System.out.println(numeroLido+" foi lido. Pelo "+this.getName());
	}
	
	public boolean estaConcluido() {
		return this.concluido;
	}

	public Future getFuture() {
		return this.f;
	}
}
