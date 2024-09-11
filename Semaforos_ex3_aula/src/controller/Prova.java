package controller;

import model.Atleta;

import java.util.concurrent.Semaphore;

public class Prova {
    private static final Semaphore semaforoArmas = new Semaphore(5); // 5 armas 
    private static final Atleta[] atletas = new Atleta[25];
    private static int posicaoChegada = 1; // Para controle da pontuação por posição

    public static void iniciarProva() {
        // Criar 25 atletas
        for (int i = 0; i < atletas.length; i++) {
            atletas[i] = new Atleta("Atleta " + (i + 1), semaforoArmas);
        }

        // Iniciar threads
        for (Atleta atleta : atletas) {
            atleta.start();
        }

        // Aguardar a finalização de todos os atletas
        for (Atleta atleta : atletas) {
            try {
                atleta.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Exibir ranking final
        Ranking.exibirRankingFinal();
    }

    public static synchronized int registrarChegada(Atleta atleta) {
        int pontos = 260 - posicaoChegada * 10;
        System.out.println(atleta.getNome() + " chegou em " + posicaoChegada + "º lugar e recebeu " + pontos + " pontos.");
        posicaoChegada++;
        return pontos;
    }
}
