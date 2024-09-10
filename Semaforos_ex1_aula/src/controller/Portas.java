package controller;
import model.Cavaleiro;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Portas {
    private static final Semaphore semaforoPortas = new Semaphore(1); // Controla o acesso às portas
    private static final Random random = new Random();

    public static void entrarPorta(Cavaleiro cavaleiro) {
        try {
            semaforoPortas.acquire();
            int portaEscolhida = random.nextInt(4) + 1;
            System.out.println(cavaleiro.getNome() + " escolheu a porta " + portaEscolhida);
            if (portaEscolhida == 1) {
                System.out.println(cavaleiro.getNome() + " encontrou a saída e sobreviveu!");
            } else {
                System.out.println(cavaleiro.getNome() + " encontrou um monstro e foi devorado!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforoPortas.release();
        }
    }
}
