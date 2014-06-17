package materia;

import java.util.ArrayList;

public class Estante {
 private Livro[] livros;
 
 
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
 
 public Livro pegarLivro(int posicao) {  // tira o livro da posição solicitada da estante e coloca null no lugar sinalizando que não há livro lá
	 Livro auxiliar = this.livros[posicao]; 
	 this.livros[posicao] = null;
	 return auxiliar;
 }
 
 public void devolverLivro(int posicao, Livro livro) {  //devolve o livro para usa respectiva posição na estante
	 this.livros[posicao] = livro;
 }
 
 public int numeroDeLivros() {
	 return this.livros.length;
 }
 
 public String toString() {
	 String auxiliar = "";
	 for(int i = 0; i<this.livros.length; i++) {
		 auxiliar+=this.livros[i]+"  ";
	 }
	 return auxiliar;
 }
}
