package universidade;

public class Estante {
 private Livro[] livros = new Livro[8];
 
 public Estante () {
	 int ident = 1;
	 for(int i = 0 ; i < 8 ; i++) {
		 if(i < 5) {
			 livros[i] = new Livro(ident, 4);
		 } else {
			livros[i] = new Livro(ident, 7); 
		 }
		 ident++;
	 }
 }
 public Livro pegarLivro(int posicao) {
	 return livros[posicao];
 }
}
