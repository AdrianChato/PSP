package Unidad1.Boletin1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AnalizadorTemperaturas {
private static final String rutar ="src/main/resources/";
	
	public AnalizadorTemperaturas() {
		super();
	}

	public int tempigualmas(String ruta,String temp) throws IOException {
		int total= 0;
		Scanner sc = null;
		FileReader f = new FileReader(ruta);
		sc = new Scanner(f);
		int tempint = Integer.parseInt(temp);
		while(sc.hasNextInt()) {
			int num = sc.nextInt();
			if(tempint<=num) {
				total++;
				
			}
		}
		sc.close();
	    f.close();
	    
	    
		String rutaresultado = rutar + temp + ".txt";
		FileWriter f1 = new FileWriter(rutaresultado);
		f1.write(String.valueOf(total));
		f1.close();
		return total;
		
	}
public static void main(String[] args) throws IOException {
	String ruta = rutar+ args[0];
	String temp = args[1];
	AnalizadorTemperaturas a = new AnalizadorTemperaturas();
	System.out.println(a.tempigualmas(ruta, temp));
}
}
