package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KillController {
	public KillController(){
		super();
	}
	private String os(){
		return System.getProperty("os.name").toLowerCase();
	}
	public void listaProcessos(){
		String So = os();
		if(So.contains("windows")){
			try {
				@SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(So.contains("linux")){
			try {
				@SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("ps -ef");
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                }
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.print("Sistema só funciona para Windows ou Linux");
		}
	}
	public void mataPid(int PID){

		String So = os();
		if(So.contains("windows")){
			try {
				@SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("TASKKILL /PID "+PID);
				int exitValue = process.waitFor(); // Espera o término do processo
                if (exitValue != 0) {
                    System.out.println("Erro ao matar o processo no Windows. Código de saída: " + exitValue);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
		}else if(So.contains("linux")){
			try {
				@SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("kill -9 "+PID);
				int exitValue = process.waitFor();
                if (exitValue != 0) {
                    System.out.println("Erro ao matar o processo no Windows. Código de saída: " + exitValue);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
		}else{
			System.out.print("Sistema só funciona para Windows ou Linux");
		}
	}
	public void mataNome(String nome){
		String So = os();
		if(So.contains("windows")){
			try {
				@SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("TASKKILL /IM "+nome);
				int exitValue = process.waitFor(); // Espera o término do processo
                if (exitValue != 0) {
                    System.out.println("Erro ao matar o processo no Windows. Código de saída: " + exitValue);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
		}else if(So.contains("linux")){
			try {
				@SuppressWarnings("deprecation")
				Process process = Runtime.getRuntime().exec("pkill -f "+nome);
				int exitValue = process.waitFor();
                if (exitValue != 0) {
                    System.out.println("Erro ao matar o processo no Windows. Código de saída: " + exitValue);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
		}else{
			System.out.print("Sistema só funciona para Windows ou Linux");
		}
	}
}
