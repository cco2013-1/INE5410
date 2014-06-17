package materia;


public class Lider extends Aluno {
	private Estante estante;
	private boolean[] lidos;
	private int numeroLidos;
	private int posicaoDoAtual;
	private Livro pego;

	public Lider(Grupo grupo, Estante estante) { 
		super(grupo); 
		this.estante = estante;
		this.lidos = new boolean[this.estante.numeroDeLivros()];  //array que verificará quais livros já foram lidos
		for(int i = 0 ; i<this.estante.numeroDeLivros(); i++) {
			this.lidos[i] = false;
		}
	}

	public void run() {
		do{
			pego = null;
			this.grupo.resetarFinalizados();
			do{
				posicaoDoAtual= (int)(Math.random()*this.estante.numeroDeLivros()); //sorteia uma posição para pegar na estante
				if(!(lidos[posicaoDoAtual])){ //se já não leu
					pego = this.pegar(posicaoDoAtual); //pega o livro na posição sorteada
				}


			}while(lidos[posicaoDoAtual]|| pego==null); //se ele já leu ou não pegou livro algum
			this.grupo.modificarAtual(pego); //atualiza o livro do grupo
			grupo.pegarAtual().ler(); //le o livro
			++this.numeroLidos; 
			this.lidos[posicaoDoAtual] = true; //atualiza o array de livros lidos
			Aluno alunos[] = this.grupo.pegarAlunos();
			for(int i=0; i<alunos.length; i++){
				alunos[i].run(); //chama os alunos para ler
			}
			while(this.grupo.pegarFinalizados()!=3) { //espera até todos lerem

			}
			this.devolver(); //devolve o livro
		}while(numeroLidos!=5); //espera até pegar os livros e todos lerem
		this.grupo.finalizou(); //diz que o grupo finalizou

	}

	public Livro pegar(int posicao) {
		return this.estante.pegarLivro(posicao);

	}

	public void devolver() {
		this.estante.devolverLivro(posicaoDoAtual, pego);
	}

}

