package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	private String os(){
		return System.getProperty("os.name").toLowerCase();
	}
	public void ip() {
        String so = os();
        
        if (so.contains("windows")) {
            try {
                @SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("ipconfig");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                boolean adaptador = false;
                
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    
                    if (line.contains("Adaptador")) {
                        System.out.println("\n" + line);
                        adaptador = true;
                    }
                    if (adaptador && line.startsWith("IPv4")) {
                        System.out.println(line);
                        adaptador = false; 
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (so.contains("linux")) {
            try {
                @SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("ifconfig");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                String adapterName = null;

                while ((line = reader.readLine()) != null) {
                    line = line.trim();

                    if (line.matches("^[a-zA-Z0-9]+:")) {
                        adapterName = line.split(":")[0];
                    }
                    if (adapterName != null && line.contains("inet ") && !line.contains("inet6")) {
                        String ipv4 = line.split(" ")[1];
                        System.out.println("\n" + adapterName);
                        System.out.println("IPv4: " + ipv4);
                        adapterName = null;
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Sistema só funciona para Windows ou Linux");
        }
    }
	public void ping() {
        String so = os();
        String command = "";

        if (so.contains("windows")) {
            command = "ping -n 10 www.google.com.br";
        } else if (so.contains("linux")) {
            command = "ping -c 10 www.google.com.br";
        } else {
            System.out.println("Sistema só funciona para Windows ou Linux");
            return;
        }

        try {
            @SuppressWarnings("deprecation")
			Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (so.contains("windows") && line.contains("Média =")) {
                    String[] parts = line.split(",");
                    for (String part : parts) {
                        if (part.trim().startsWith("Média")) {
                            System.out.println(part.trim());
                            break;
                        }
                    }
                } else if (so.contains("linux") && line.contains("avg")) {
                    String[] parts = line.split("/");
                    if (parts.length > 4) {
                        System.out.println("Tempo médio: " + parts[4] + " ms");
                    }
                }
            }
            reader.close();
            int exitValue = process.waitFor();
            if (exitValue != 0) {
                System.out.println("Erro ao executar o comando de ping. Código de saída: " + exitValue);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
