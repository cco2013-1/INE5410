package buscaSemaforo;

import java.util.ArrayList;

public class PrincipalSemaforo {
	public static void main(String[] args) {
		BuscaSemaforo busca = new BuscaSemaforo(".log", "/home/matheus");
		System.out.println("Iniciando abusca");
		busca.start();
	}

}
