package model;

import controller.Ranking;
import controller.Prova;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Atleta extends Thread {
    private static final int corrida = 3000; 
    private static final int ciclismo = 5000; 
    private String nome;
    private int velocidadeCorrida; 
    private int velocidadeCiclismo; 
    private int distanciaPercorrida;
    private int pontuacaoCorrida;
    private int pontuacaoTiro = 0;
    private int pontuacaoFinal;
    private Semaphore semaforoArmas;
    private Random random = new Random();

    public Atleta(String nome, Semaphore semaforoArmas) {
        this.nome = nome;
        this.velocidadeCorrida = random.nextInt(6) + 20; // 20 a 25 
        this.velocidadeCiclismo = random.nextInt(11) + 30; // 30 a 40 
        this.distanciaPercorrida = 0;
        this.semaforoArmas = semaforoArmas;
    }

    @Override
    public void run() {
        try {
            // Corrida
            while (distanciaPercorrida < corrida) {
                distanciaPercorrida += velocidadeCorrida;
                Thread.sleep(30); 
            }
            System.out.println(nome + " terminou a corrida!");

            // Determinar a pontuação da corrida
            pontuacaoCorrida = Prova.registrarChegada(this);

            // Tiro ao alvo
            semaforoArmas.acquire(); // Aguardar disponibilidade de arma
            System.out.println(nome + " está fazendo os tiros.");
            for (int i = 0; i < 3; i++) {
                int pontuacaoTiroAtual = random.nextInt(11); // Pontuação de 0 a 10
                pontuacaoTiro += pontuacaoTiroAtual;
                Thread.sleep(random.nextInt(2500) + 500); // Cada tiro leva entre 0,5s e 3s
            }
            semaforoArmas.release();
            System.out.println(nome + " terminou o tiro ao alvo!");

            // Ciclismo
            distanciaPercorrida = 0;
            while (distanciaPercorrida < ciclismo) {
                distanciaPercorrida += velocidadeCiclismo;
                Thread.sleep(40);
            }
            System.out.println(nome + " terminou o ciclismo!");

            // Registrar pontuação final
            pontuacaoFinal = pontuacaoCorrida + pontuacaoTiro;
            Ranking.adicionarAtletaAoRanking(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getPontuacaoFinal() {
        return pontuacaoFinal;
    }

    public String getNome() {
        return nome;
    }
}
