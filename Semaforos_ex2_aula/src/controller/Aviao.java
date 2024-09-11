package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Aviao extends Thread {

    private String nome;
    private static final Semaphore decolagem = new Semaphore(2); // Máximo de 2 aviões na área de decolagem
    private static final Random random = new Random();

    public Aviao(String nome) {
        this.nome = nome;
    }

    @Override
    public void run() {
        tentarDecolagem();
    }

    private void tentarDecolagem() {
        System.out.println(nome + " está se preparando para decolar.");

        try {
            decolagem.acquire();
            System.out.println(nome + " entrou na área de decolagem.");

            realizarFase("taxiar", 500, 1000);
            realizarFase("decolagem", 600, 800);
            realizarFase("afastamento", 300, 800);

            System.out.println(nome + " completou a decolagem e está saindo da área de decolagem.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            decolagem.release();
        }
    }

    private void realizarFase(String fase, int minMs, int maxMs) throws InterruptedException {
        int duracao = minMs + random.nextInt(maxMs - minMs + 1);
        System.out.println(nome + " está na fase de " + fase + " por " + duracao + " ms.");
        Thread.sleep(duracao);
    }
}