package materia;

public class Principal {
	public static final int unidadeTempo = 10;
	public static void main(String[] args) {
		int equipesFinalizadas = analise(true, 8);
		int numeroAnalizado = 9; //numero de livros na estante para que todos consigam entregar 
	}
	
	public static int analise(boolean resultados, int quantidadeLivros) {
		Grupo[] grupos = new Grupo[15];
		Estante estante = new Estante(quantidadeLivros);
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
			if(grupos[i].trabalhoFinalizado()){ // se o grupo terminou
				finalizados++;
			}
		}
		if(!resultados) return finalizados; //se não quiser mostrar os resultador retorna isso
		System.out.println("Após 200 unidades de tempo "+finalizados+" conseguiram entregar o trabalho");
			return 0;
	}

}
