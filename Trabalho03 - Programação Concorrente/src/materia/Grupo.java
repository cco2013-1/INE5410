package materia;

public class Grupo{
	private Lider lider;
	private Aluno[] alunos;
	private Livro atual;
	private int finalizados;  //número de alunos que leram o livro atual
	private boolean trabalhoFinalizado = false; 
	
	
	public Grupo(Estante estante, int qntAlunos) {
		qntAlunos--;
		this.lider = new Lider(this,estante);
		this.lider.start();
		this.alunos = new Aluno[qntAlunos];
		for(int i = 0; i< qntAlunos; i++) {
			this.alunos[i] = new Aluno(this);
		}
	}


	public Livro pegarAtual() {
		return this.atual;
	}
	
	public void modificarAtual(Livro livroNovo) { //atualiza o livro do grupo
		this.atual = livroNovo;
	}
	
	public Aluno[] pegarAlunos() { //retorna o array de alunos
		return this.alunos;
	}


	public int pegarFinalizados() { //retorna o número de alunos finalizados do grupo
		return this.finalizados;
	}
	
	public void atualizarFinalizados() { //sinaliza que um aluno leu o livro atual
		this.finalizados++;
	}
	
	public void resetarFinalizados() { //assim que um novo livro chega, é chamado para zerar o numero de alunos que leram o livro atual
		this.finalizados = 0;
	}

	public boolean trabalhoFinalizado() { //retora o boolean que sinaliza se o trabalho já finalizou
		return this.trabalhoFinalizado;
	}
	
	public void finalizou() { //grupo finalizado
		this.trabalhoFinalizado = true;
	}
}
