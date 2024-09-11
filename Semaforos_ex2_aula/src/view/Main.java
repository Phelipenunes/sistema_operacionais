package view;

import controller.Aviao;

public class Main {

    public static void main(String[] args) {
        // Cria e inicia 12 threads de aviões
        for (int i = 0; i < 12; i++) {
        	Aviao a = new Aviao("Avião " + (i + 1));
            a.start();
        }
    }
}