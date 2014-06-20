package busca;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		Busca busca = new Busca(".log", "/home/matheus");
		System.out.println("Iniciando abusca");
		busca.start();
	}

}
