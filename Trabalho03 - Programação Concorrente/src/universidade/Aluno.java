package universidade;

public class Aluno extends Thread {
	private String nome;
	private int grupo;
	private int[] livrosLidos = new int[4];
	private boolean lider;
	private Estante estante;
	
	public Aluno(int nome, int grupo, boolean lider, Estante estante) {
		this.nome = "Aluno - "+nome;
		this.grupo = grupo;
		this.lider = lider;
	}
	
	public void run(){
		this.estante.pegarLivro((int)(Math.random()*8)+1);
	}
}
