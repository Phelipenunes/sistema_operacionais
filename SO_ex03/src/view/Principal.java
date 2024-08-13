package view;
import controller.Metodos;
import javax.swing.JOptionPane;
public class Principal {
	public static void main(String[] args) {
		Metodos m = new Metodos();
		int num =0;
		int i;
		while(num <= 0||num > 100) {
			num = Integer.parseInt(JOptionPane.showInputDialog("insira tamanho do vetor"));
			int[]vetor = {87, 43, 12, 98, 65, 2, 77, 34, 55, 39, 72, 14, 61, 28, 90, 31, 1, 56, 88, 21, 19, 7, 53, 64, 82, 38, 24, 93, 15, 47, 9, 73, 33, 11, 26, 48, 62, 30, 50, 75, 4, 84, 41, 67, 10, 92, 5, 66, 18, 37, 79, 85, 23, 95, 3, 71, 45, 40, 13, 25, 83, 60, 17, 44, 96, 70, 32, 6, 52, 16, 80, 49, 8, 76, 91, 36, 22, 58, 27, 20, 86, 63, 74, 51, 99, 35, 54, 46, 68, 94, 42, 78, 29, 81, 89};
			/*for( i = 0; i<num; i++) {
			vetor[i]=  Integer.parseInt(JOptionPane.showInputDialog("insira valor do vetor"));	
		}*/
		m.Verifica(vetor);
	 }
	}
}