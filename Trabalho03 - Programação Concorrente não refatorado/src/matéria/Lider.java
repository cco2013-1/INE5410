package matéria;


public class Lider extends Aluno {
	Estante estante;
	boolean[] lidos;
	int numeroLidos;
	int posicaoDoAtual;
	public Lider(Grupo grupo, Estante estante) { 
		super(grupo); 
		this.estante = estante;
		this.lidos = new boolean[this.estante.livros.length];
		for(int i = 0 ; i<this.estante.livros.length ; i++) {
			this.lidos[i] = false;
		}
	}

	public void run() {
		do{
			Livro pego = null;
			this.grupo.finalizados=0;
			do{
				posicaoDoAtual= (int)(Math.random()*this.estante.livros.length);
				pego = this.pegar(posicaoDoAtual);
				
			}while(lidos[posicaoDoAtual]|| pego==null);
			this.grupo.atual = pego;
			System.out.println("================LIDER "+Thread.currentThread().getName()+" LEU  "+this.grupo.atual);
			grupo.atual.ler();
			++this.numeroLidos;
			this.lidos[posicaoDoAtual] = true;
			for(int i=0; i<3; i++){
				this.grupo.alunos[i].run();
			}
			while(this.grupo.finalizados!=3) {

			}
			this.devolver();
		}while(numeroLidos!=5);
		System.out.println("F5NALIZOOOOOOOOOOOOOOOOOOOOOOOOOU");
		this.grupo.trabalhoFinalizado = true;

	}

	public Livro pegar(int posicao) {
		Livro pego = this.estante.livros[posicao];
		this.estante.livros[posicao] = null;
		return pego;

	}

	public void devolver() {
		System.out.println("--------------LIDER "+Thread.currentThread().getName()+" devolvendo o livro "+this.grupo.atual);
		this.estante.livros[posicaoDoAtual] = this.grupo.atual;
		System.out.println("----Estado da Estante---- "+this.estante.toString());
	}

}

