package matéria;

import java.util.ArrayList;

public class Estante {
 public Livro[] livros;
 
 
 /*Parametros
  * número de livros postos na estante
  * */
 
 public Estante (int numeroLivros) {
	 this.livros = new Livro[numeroLivros];
	 for(int i = 0 ; i < numeroLivros ; i++) { //criando os livros 
		 if(i < 4) {
			 livros[i] = new Livro(4);
		 } else if(i<8){
			livros[i] = new Livro(7); 
		 }else {
			 livros[i] = new Livro(6);
		 }
	 }
 }
public String toString() {
	String toString = "";
	for(int i = 0; i<this.livros.length; i++){
		toString += this.livros[i]+"        ";
	}
	return toString;
}
}
