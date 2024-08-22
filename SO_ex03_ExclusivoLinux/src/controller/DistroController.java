package controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistroController {
	public DistroController(){
		super();
	}
	private String os(){
		return System.getProperty("os.name");
	}
	public void exibeDistro() {
		String So = os();
		if(So.contains("linux")) {
			try {
                @SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("cat /etc/os-release");//executa o comando "..." no CMD do SO.
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));//inputStreamReader pega a saida de dados em binario e o new BufferedReader trasforma em texto.
                String line;

                // Exibe as linhas retornadas pelo comando
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("NAME=") || line.startsWith("VERSION=")) {
                        System.out.println(line);
                    }
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
		}else {
			System.out.print("O sistema operacional não é o Linux");
		}
	}
}
