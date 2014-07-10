package buscaSemaforo;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.util.concurrent.Semaphore;

public class BuscaSemaforo extends Thread{
	private final int totalThreads = 12;
	private final int threadsAutorizadas = 6;
	private Task task = new Task();
	private String nomeArquivo;
	private File caminho;
	private Thread[] threads = new Thread[this.totalThreads];
	private Semaphore semaforo = new Semaphore(this.threadsAutorizadas);
	

	public BuscaSemaforo(String nome, String caminhoInicial) {
		this.task.adicionarCaminho(caminhoInicial);
		for(int i = 0; i < this.totalThreads ; i++) {
			this.threads[i] = new Procurador(this.task, nome, this.semaforo);
			this.threads[i].start();
		}
	}  
}
