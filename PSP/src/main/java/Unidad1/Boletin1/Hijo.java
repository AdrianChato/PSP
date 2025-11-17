package Unidad1.Boletin1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Hijo {
	
	private static final String rutar ="src/main/resources/";
	public Hijo( ) {
		super();
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("esto es el hijo " + 7);
		//throw new FileNotFoundException();
		String ruta = rutar+ args[0];
		String palabra = args[1];
		ContadorPalabrasPSP c = new ContadorPalabrasPSP();
		System.out.println(c.contar(ruta, palabra));
		System.out.println(4);
	}
	public int contar(String ruta, String palabra) throws FileNotFoundException {
		Scanner sc = null;
		FileReader f = new FileReader(ruta);
		int contador =0;
		sc = new Scanner(f);
		while(sc.hasNextLine()) {
			String pa = sc.nextLine();
			String[] partes = pa.split(" ");
			for(String p : partes) {
				if(p.equalsIgnoreCase(palabra)) {
					contador++;
				}
			}
		}
		return contador;
	}
}
