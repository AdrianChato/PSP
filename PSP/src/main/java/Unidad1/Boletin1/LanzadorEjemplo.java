package Unidad1.Boletin1;

import java.io.IOException;

public class LanzadorEjemplo {
	
	public static void main(String[] args) {
		
		LanzadorEjemplo lanzador = new LanzadorEjemplo();
		lanzador.ejecutaProcesoCompila(rutaSource,directorioGenerarClasses);
		lanzador.ejecutaProcesoJava();
		
	}
	
	private static final String directorioGenerarClasses = "C:\\Users\\alumno\\Desktop\\Spring\\PSP\\target";
	private static final String rutaSource = "C:\\Users\\alumno\\Desktop\\Spring\\PSP\\src\\main\\java\\Unidad1\\Boletin1\\EjemploHijo.java";


	public void ejecutaProcesoCompila (String rutaSource,String directorioGenerarClasses) {
		String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSource + "\\Unidad1\\Boletin1\\Gestiona.java" };
		
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			Process proceso1 = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ejecutaProcesoJava () {
		String[] comando = { "java", "-cp", rutaSource, "hola", "adios"};
		
		ProcessBuilder pb = new ProcessBuilder(comando);
		try {
			Process proceso1 = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
