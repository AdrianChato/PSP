package Unidad1.Boletin1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ContadorPalabrasPSP {
	

	private static final Logger logger =LogManager.getLogger(ContadorPalabrasPSP.class);
	private static final String rutar ="src/main/resources/";
	public ContadorPalabrasPSP( ) {
		super();
		
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
	public static void main(String[] args) throws FileNotFoundException {
		String ruta = rutar+ args[0];
		String palabra = args[1];
		ContadorPalabrasPSP c = new ContadorPalabrasPSP();
		System.out.println(c.contar(ruta, palabra));
		System.out.println(4);
	}
}
