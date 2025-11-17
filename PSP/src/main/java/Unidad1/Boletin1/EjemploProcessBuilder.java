package Unidad1.Boletin1;

import java.io.IOException;

public class EjemploProcessBuilder {

	public static void main(String[] args) {
		String [] arg = {"C:\\Program Files\\MySQL\\MySQL Workbench 8.0\\MySQLWorkbench.exe"};
		String [] comando = {"cmd.exe", "/C", "start", "cmd.exe", "/K", "tasklist"};
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			Process p = pb.start();
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
