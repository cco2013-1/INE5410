package matéria;

public class Principal {
	public static final int unidadeTempo = 10;
	public static void main(String[] args) {
		int equipesFinalizadas = analise(true, 25);
		int numeroAnalizado = 9; //numero de livros na estante para que todos consigam entregar 
//		while(true) {
//			if(analise(false, numeroAnalizado) == 15) //se todos conseguirem entregar
//				break; // sai fora
//		}
//		System.out.println("Foram necessários "+ numeroAnalizado+" livros para que todas as equipes entreguem o trabalho");
	}
	
	public static int analise(boolean resultados, int quantidadeLivros) {
		Grupo[] grupos = new Grupo[15];
		Estante estante = new Estante(quantidadeLivros);
		System.out.println(estante.toString());
		for(int i = 0; i<grupos.length; i++){
			grupos[i] = new Grupo(estante, 4);
		}
		
		try{
			Thread.sleep(200*unidadeTempo); //esperando até o prazo do trabalho ser estourado
		}catch(InterruptedException e){
			System.out.println("Ferrou joão!");
		}
		int finalizados=0; //número de grupos que terminaram
		for(int i = 0; i<grupos.length; i++){
			if(grupos[i].trabalhoFinalizado){ // se o grupo terminou
				finalizados++;
			}
		}
		if(!resultados) return finalizados; //se não quiser mostrar os resultador retorna isso
		System.out.println("Após 200 unidades de tempo "+finalizados+" conseguiram entregar o trabalho");
		for(int i = 0; i<quantidadeLivros; i++) {
			//System.out.println("O livro"+i+" foi lido"+estante.livros[i].vezesQueFoiLido+" vezes.");
		}
//		int tempoRemanescente = 0;
//		boolean finalizado;
//		do{
//			tempoRemanescente++;
//			try {
//				Thread.sleep(1*unidadeTempo);
//			}catch(InterruptedException e) {
//				System.out.println(" Ferrou de novo joão ");
//			}
//			finalizado = true;
//			for(int i = 0; i<grupos.length; i++) {
//				if(grupos[i].finalizados < 4) {
//					finalizado = false;
//					break;
//				}
//			}
//		}while(!finalizado);
//		System.out.println("Foi necessário "+tempoRemanescente+200+" unidades de tempo para que todos finalizem o trabalho.");
		return 0;
	}

}
