package Unidad1.Boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Padre {
	private static final String diractorioGenerarClasses = "\\target\\";
	private static final String rutaFicherosJava = "C:\\Users\\alumno\\Desktop\\Spring\\PSP\\src\\main\\java\\Unidad1\\Boletin1\\Hijo.java";

	public void compilaClaseJava() {
		try {
			String[] comando = { "javac", "-d", diractorioGenerarClasses, rutaFicherosJava };
			ProcessBuilder pb = new ProcessBuilder(comando);
			Process p = pb.start();
			pb.inheritIO();
			Process proceso = pb.start();
			int exit = proceso.waitFor();
			System.out.println("compila: " + exit);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void ejecutaProcesoJava() {
		String[] comando = { "java", "-cp", diractorioGenerarClasses, rutaFicherosJava };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			// pb.redirectErrorStream(true);
			// pb.inheritIO();
			Process p1 = pb.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

			int exit = p1.waitFor();
			System.out.println("ejecuta: " + exit);

			if (exit != 0) {
				String errorLinea = errorReader.readLine();
				while (errorLinea != null) {
					System.err.println("Error Padre: " + errorLinea);
					errorLinea = errorReader.readLine();
				}
			} else {
				String linea = reader.readLine();

				while (linea != null) {
					System.out.println("Padre: " + linea);
					linea = reader.readLine();
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		Padre p = new Padre();
		p.compilaClaseJava();
		p.ejecutaProcesoJava();
	}
}