package matéria;

public class Grupo{
	Lider lider;
	Aluno[] alunos;
	Livro atual;
	int finalizados;
	boolean trabalhoFinalizado;
	
	
	public Grupo(Estante estante, int qntAlunos) {
		qntAlunos--;
		this.lider = new Lider(this,estante);
		this.lider.start();
		this.alunos = new Aluno[qntAlunos];
		for(int i = 0; i< qntAlunos; i++) {
			this.alunos[i] = new Aluno(this);
		}
	}
}
