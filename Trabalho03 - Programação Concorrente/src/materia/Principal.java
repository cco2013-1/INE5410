package materia;

public class Principal {
	public static final int unidadeTempo = 10;
	public static void main(String[] args) {
		int analise = analise(true, 8);
		int numeroAnalizado = 8; //numero de livros na estante para que todos consigam entregar 
		int equipesFinalizadas = 0;
		while(equipesFinalizadas != 15){
			numeroAnalizado++;
			equipesFinalizadas = analise(false, numeroAnalizado);
		}
		System.out.println("\nForam necessários "+numeroAnalizado+" livros para que todos terminem em 200 unidades de tempo");
	}

	public static int analise(boolean resultados, int quantidadeLivros) {
		System.out.println("\n==== TESTE COM "+quantidadeLivros+" LIVROS====\n");
		Grupo[] grupos = new Grupo[15];
		Estante estante = new Estante(quantidadeLivros);
		for(int i = 0; i<grupos.length; i++){  //criando os grupos
			grupos[i] = new Grupo(estante, 4);
		}

		try{
			Thread.sleep(200*unidadeTempo); //esperando até o prazo do trabalho ser estourado
		}catch(InterruptedException e){
			System.out.println("Ferrou joão!");
		}
		int finalizados=0; //número de grupos que terminaram
		for(int i = 0; i<grupos.length; i++){
			if(grupos[i].trabalhoFinalizado()){ // se o grupo terminou
				finalizados++;
			}
		}
		int tempoExtra = 0;
		if(resultados){ 
			System.out.println("Após 200 unidades de tempo "+finalizados+" conseguiram entregar o trabalho\n");
			while(finalizados != 15){
				finalizados = 0;
				try{
					Thread.sleep((tempoExtra++)*unidadeTempo);
				}catch(InterruptedException e){
					System.out.println("Ferrou joão 2");
				}
				
				for(int i = 0; i<grupos.length; i++){
					if(grupos[i].trabalhoFinalizado()){ // se o grupo terminou
						finalizados++;
					}
				}
			}

			tempoExtra+=200;
			System.out.println("Foram necessários "+tempoExtra+" unidades de tempo para que todos terminem seu trabalho\n");
		}
		
		if(!resultados){
			System.out.println("Com "+quantidadeLivros+" livros "+finalizados+" grupos conseguiram entregar o trabalho em 200 unidades de tempo\n");
		}
		
		System.out.println("== LIVROS MAIS LIDOS ==");
		for(int i = 0; i< estante.numeroDeLivros(); i++) { //mostrando quantas vezes cada livro foi lido
			try{
				System.out.println("O livro "+i+" foi livro "+estante.pegarLivro(i).vezesQueFoiLido()+ " vezes");
			}catch(NullPointerException e) {

			}

		}
		return finalizados;
	}

}
