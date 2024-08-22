package view;
import controller.KillController;
public class Principal {
	public static void main(String[] args){
		KillController m = new KillController();
		int PID = 15760;
		String nome =  "Spotify.exe";
		m.listaProcessos();
		m.mataPid(PID);
		m.mataNome(nome);
	}
}
