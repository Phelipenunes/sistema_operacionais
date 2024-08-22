package view;
import controller.Metodos;
public class Principal {
	public void main(String[] args) {
	Metodos m = new Metodos();
	String proc = "regedit.exe";
	m.callProcess(proc);
	}
}
