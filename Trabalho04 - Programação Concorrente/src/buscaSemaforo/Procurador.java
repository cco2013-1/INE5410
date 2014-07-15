package buscaSemaforo;

import java.io.File;
import java.util.concurrent.Semaphore;

public class Procurador extends Thread {
	private Task task;
	private Semaphore semaforo;
	private String procura;
	private String encontrado;
	private String caminhoDoEncontrado;
	private long tamanho;
	
	public Procurador (Task task, String procura, Semaphore semaforo, long tamanho) {
		this.task = task;
		this.procura = procura;
		this.semaforo = semaforo;
		this.tamanho = tamanho;
	}
	
	public void run () {
		while(!this.task.taskVazia()){ 
			String caminho = null;
			try {
				caminho = this.task.pegarCaminho();
			}catch(Exception e){
				
			}
			
			if(caminho != null){
				File arquivo = new File(caminho);
				this.procurar(this.procura, arquivo);
				if(this.encontrado!= null){
					System.out.println("Achei----> "+this.encontrado);
					this.encontrado = null;
				}
				
			}
		}
	}
	
	public void procurar(String palavra, File arquivo) {  
		try{ //tenta criar um arquivo com o caminho dado
			this.semaforo.acquire();
			if (arquivo.isDirectory()) {  //vê se a string passada é um diretório
				File[] subPastas = arquivo.listFiles();  //cria um array de subpastas
				for (int i = 0; i < subPastas.length; i++) {  
					this.task.adicionarCaminho(subPastas[i].getPath());
				}  
			}  
			else if (arquivo.getName().equalsIgnoreCase(palavra) || arquivo.getTotalSpace() <= this.tamanho){
				this.encontrado = arquivo.getName();  
				this.caminhoDoEncontrado = arquivo.getAbsolutePath();
			}
			else if (arquivo.getName().indexOf(palavra) > -1 || arquivo.getTotalSpace() <= this.tamanho){
				this.encontrado = arquivo.getName();  
				this.caminhoDoEncontrado = arquivo.getAbsolutePath();
			}
		}catch (InterruptedException e) {
			System.out.println("Foi interrompido");
		}catch (Exception e) {
			System.out.println("Caminho inválido");
		}finally{
			this.semaforo.release();
		}
	}  
}
