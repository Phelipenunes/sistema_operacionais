package threads;

public class Threads extends Thread {
	private int[] linha;
    private int indexLinha;
    
    public Threads(int[] linha, int indexLinha) {
        this.linha= linha;
        this.indexLinha = indexLinha;
    }
    public void run() {
        int soma = 0;
        for (int numero : linha) {
            soma += numero;
        }

        // Imprimir o resultado
        System.out.println("Linha " + indexLinha + " soma: " + soma);
    }
}
