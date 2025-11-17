package Unidad1.Boletin1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanzadorAnalisisTemperatura {
	private final static String directorioGenerarClasses = "target";
	private final static String rutaSourceJava = "src/main/java/";
	private static final Logger logger = LogManager.getLogger(LanzadorAnalisisTemperatura.class);

	public void compila() {
		String[] comando = { "javac", "-d", directorioGenerarClasses,
				rutaSourceJava + "Unidad1/boletin2/AnalizadorTemperaturas.java" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			pb.redirectErrorStream(true);
			pb.inheritIO();
			Process p1 = pb.start();
			int exit = p1.waitFor();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	public void ejecuta(String ficheroTemperaturas, String temp) {
		String[] comando = { "java", "-cp", "target/classes", "Unidad1.Boletin1.AnalizadorTemperaturas", ficheroTemperaturas,
				temp };

		ProcessBuilder pb = new ProcessBuilder(comando);
		pb.redirectErrorStream(true);
		pb.inheritIO();

		try {
			pb.start();
			logger.info("Lanzado proceso temp " + temp);
		} catch (IOException e) {
			logger.error("Error : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		LanzadorAnalisisTemperatura lanzador = new LanzadorAnalisisTemperatura();
		lanzador.compila();

		String ficheroTemperaturas = "datos.txt";

		int[] umbrales = { 10, 20, 25, 30, 35 };

		List<Process> procesos = new ArrayList<>();

		for (int u : umbrales) {
			lanzador.ejecuta(ficheroTemperaturas, String.valueOf(u));
		}

		// logger.info("Todos los procesos hijos han sido lanzados.");
	}

}
