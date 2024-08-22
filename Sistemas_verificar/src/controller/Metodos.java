package controller;

public class Metodos {
	public Metodos() {
		super();
	}
	public void os() {
		String os = System.getProperty("os.name");
		String ver = System.getProperty("os.version");
		String arch = System.getProperty("os.arch");
		System.out.print(os+ " - " + ver + " - " + arch);
	}
	public void callProcess(String proc) {
		try {
			Runtime.getRuntime().exec(proc);
		} catch(Exception e) {
			//System.err.println(e.getMessage());
			if(e.getMessage().contains("740")){
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c ");
				buffer.append(" ");
				buffer.append(proc);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (Exception e2) {
					System.err.println(e2.getMessage());
				}
			}else {
				System.err.println(e.getMessage());
			}
		}
		
	}
	
}
