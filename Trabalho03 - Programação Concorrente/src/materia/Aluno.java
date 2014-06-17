package materia;

public class Aluno extends Thread {
	protected Grupo grupo;
	
	public Aluno(Grupo grupo) {
		this.grupo = grupo;
	}

	public void run() {
		this.grupo.pegarAtual().ler(); //Lê o livro que o líder trouxe para o grupo
		this.grupo.atualizarFinalizados(); //Chama o método que atualiza o numero de alunos finalizados no grupo
	}
}
