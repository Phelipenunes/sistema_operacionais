package controller;
import model.Cavaleiro;
import java.util.concurrent.Semaphore;

public class Corredor {        // cria os cavaleiros e os semaforos.
    private static final Semaphore semaforoTocha = new Semaphore(1);
    private static final Semaphore semaforoPedra = new Semaphore(1);
    
    public static void iniciarCorrida() {
    	
        Cavaleiro[] cavaleiros = {
            new Cavaleiro("Cavaleiro1", semaforoTocha, semaforoPedra),
            new Cavaleiro("Cavaleiro2", semaforoTocha, semaforoPedra),
            new Cavaleiro("Cavaleiro3", semaforoTocha, semaforoPedra),
            new Cavaleiro("Cavaleiro4", semaforoTocha, semaforoPedra)
        };

        for (Cavaleiro cavaleiro : cavaleiros) {
            cavaleiro.start();
        }
    }

    public static void entrarPorta(Cavaleiro cavaleiro) {
        Portas.entrarPorta(cavaleiro);
    }
}
