package matéria;

public class Aluno extends Thread {
	Grupo grupo;
	public Aluno(Grupo grupo) {
		this.grupo = grupo;
	}

	public void run() {
		this.grupo.atual.ler();
		System.out.println(Thread.currentThread().getName()+" leu "+this.grupo.atual);
		this.grupo.finalizados++;
	}
}
