package model;
import controller.Corredor;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cavaleiro extends Thread {
    private static final int distanciaT = 2000;
    private static final int tocha = 500;
    private static final int pedra = 1500;
    private String nome;
    private int velocidade;
    private int distanciaPercorrida;
    private boolean temTocha = false;
    private boolean temPedra = false;
    private Semaphore semaforoTocha;
    private Semaphore semaforoPedra;
    private Random random = new Random();

    public Cavaleiro(String nome, Semaphore semaforoTocha, Semaphore semaforoPedra) {
        this.nome = nome;
        this.velocidade = random.nextInt(3) + 2; // 2 a 4
        this.distanciaPercorrida = 0;
        this.semaforoTocha = semaforoTocha;
        this.semaforoPedra = semaforoPedra;
    }

    @Override
    public void run() {
        try {
            while (distanciaPercorrida < distanciaT) {
                distanciaPercorrida += velocidade;

                // quando a distancia da tocha for alcançada e o cavaleiro ainda não tiver tocha ele tenta pegar a tocha
                // se ele conseguir pegar a tocha a velocidade aumenta.
                if (distanciaPercorrida >= tocha && !temTocha) {
                    if (semaforoTocha.tryAcquire()) {
                        temTocha = true;
                        velocidade += 2; // 
                        System.out.println(nome + " pegou a tocha! Velocidade aumentada para " + velocidade + " ms");
                    }
                }

                // mesma ideia do if acima so que para a pedra. 
                if (distanciaPercorrida >= pedra && !temPedra && !temTocha) {
                    if (semaforoPedra.tryAcquire()) {
                        temPedra = true;
                        velocidade += 2;
                        System.out.println(nome + " pegou a pedra brilhante! Velocidade aumentada para " + velocidade + " ms");
                    }
                }

                // coloca a thread para dormir por 50ms para simular a velocidade
                Thread.sleep(50);
            }

   
            System.out.println(nome + " chegou ao final!");
            Corredor.entrarPorta(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // metodo para pegar o nome do cavaleiro
    public String getNome() {
        return nome;
    }
}
