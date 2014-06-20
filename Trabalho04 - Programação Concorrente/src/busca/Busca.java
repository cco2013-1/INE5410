package busca;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Busca extends Thread{
	private String nomeArquivo;
	private File caminho;

	public Busca(String nome, String caminhoInicial) {
		this.nomeArquivo = nome;
		try{
			this.caminho = new File(caminhoInicial); //cria um arquivo com o caminho inicial dado
		}catch(Exception e){
			System.out.println("O caminho informado é inválido");
		}

	}
	
	public Busca(String nome, File caminho) {
		this.nomeArquivo = nome;
		this.caminho = caminho;
	}
	public void run() {
		this.buscar(this.nomeArquivo, this.caminho);
	}

	public void buscar(String palavra, File arquivo) {  
		try{ //tenta criar um arquivo com o caminho dado
			
			if (arquivo.isDirectory()) {  //vê se a string passada é um diretório
				File[] subPastas = arquivo.listFiles();  //cria um array de subpastas
				for (int i = 0; i < subPastas.length; i++) {  
					Busca nova = new Busca(palavra, subPastas[i]);  
					nova.start();
					if (arquivo.getName().equalsIgnoreCase(palavra)) System.out.println(this.getName()+" achou -->"+arquivo.getName()+"\n");  
					else if (arquivo.getName().indexOf(palavra) > -1) System.out.println(this.getName()+" achou -->"+arquivo.getName()+"\n");  
				}  
			}  
			else if (arquivo.getName().equalsIgnoreCase(palavra)) System.out.println(this.getName()+" achou -->"+arquivo.getName()+"\n");  
			else if (arquivo.getName().indexOf(palavra) > -1) System.out.println(this.getName()+" achou -->"+arquivo.getName()+"\n");  
		}catch (Exception e) {
			System.out.println("O caminho informado é inválido");
		}
	}  
}
