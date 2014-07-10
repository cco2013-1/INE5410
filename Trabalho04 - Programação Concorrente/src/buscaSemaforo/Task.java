package buscaSemaforo;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Task {
	private ArrayList<String> caminhos = new ArrayList<String>();
	private ReentrantLock lock = new ReentrantLock();
	public Task(){
		
	}
	public void adicionarCaminho(String path){
		this.caminhos.add(path);
	}
	
	public String pegarCaminho() {
		if(!this.caminhos.isEmpty()){
			lock.lock();
			String path =  this.caminhos.remove(0);
			lock.unlock();
			return path;
		}
		return null;
		
	}
	public boolean taskVazia() {
		if(this.caminhos.isEmpty()){
			return true;
		}
		return false;
	}
	
}
