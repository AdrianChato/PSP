package Unidad1.Boletin1;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanzadorContadorPalabra {
	private static final String rutarclase ="C:\\Users\\alumno\\Desktop\\Spring\\PSP\\src\\main\\java\\Unidad1\\Boletin1\\ContadorPalabrasPSP.java";
	private static final String rutarfichero ="C:\\Users\\alumno\\Desktop\\Spring\\PSP\\src\\main\\resources\\";
	private static final Logger logger =LogManager.getLogger(LanzadorContadorPalabra.class);
	
	public void lanzar (String rutarclase, String rutafichero) {
		String [] comando = { "javac", "-d", rutarclase, rutafichero};
		ProcessBuilder p1 = new ProcessBuilder(comando + "es");
		ProcessBuilder p2 = new ProcessBuilder(comando + "java");
		ProcessBuilder p3 = new ProcessBuilder(comando + "y");
		
	}
	
	public static void main(String[] args) {
		LanzadorContadorPalabra l = new LanzadorContadorPalabra();
		l.lanzar(rutarclase, rutarfichero);
		
				
	}

}
