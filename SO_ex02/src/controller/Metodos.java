package controller;

public class Metodos {
	public Metodos(){
		super();
	}
	public int qtdpalavras(String texto){
		String[] palavras = texto.split(";");
		int qtdpalavra = palavras.length;
		return qtdpalavra;
	}
}
