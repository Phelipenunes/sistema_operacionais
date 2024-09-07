package controller;

public class Metodos {
	public Metodos(){
		super();
	}
	public double vet1000(int vetor[]){
		long tempoI = System.nanoTime();
		for (int i = 0; i < vetor.length; i++) {
            int valor = vetor[i]; // Ação simples para simular o percurso do vetor
            valor += valor;
        }
		long tempoF = System.nanoTime();
		double tempo = tempoF - tempoI;
		return tempo;
	}
	public double vet10000(int vetor[]){
		long tempoI = System.nanoTime();
		for (int i = 0; i < vetor.length; i++) {
            int valor = vetor[i]; // Ação simples para simular o percurso do vetor
            valor += valor;
        }
		long tempoF = System.nanoTime();
		double tempo = tempoF - tempoI;
		return tempo;
	}
	public double vet100000(int vetor[]){
		long tempoI = System.nanoTime();
		for (int i = 0; i < vetor.length; i++) {
            int valor = vetor[i]; // Ação simples para simular o percurso do vetor
            valor += valor;
        }
		long tempoF = System.nanoTime();
		double tempo = tempoF - tempoI;
		return tempo;
	}

}
