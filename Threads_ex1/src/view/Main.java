package view;
import threads.Threads;
public class Main {
	public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Threads thread = new Threads();
            thread.start();
        }
    }
}