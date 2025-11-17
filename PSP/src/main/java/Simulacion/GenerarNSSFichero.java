package Simulacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarNSSFichero {
	private static final String ruta = "src/main/resources/"; // Ruta donde se guardará el archivo de salida

    public static void main(String[] args) {
        // Verifica que se haya pasado al menos un argumento (el archivo de entrada)
        if (args.length < 1) {
            System.out.println("COUNT:0"); // Si no hay argumentos, imprime 0 y termina
            return;
        }

        File entrada = new File(args[0]);               // Archivo de entrada (pasado como argumento)
        File salida = new File(ruta + "NSSs.txt");      // Archivo de salida donde se guardarán los NSS

        int contador = 0; // Contador para saber cuántos NSS se han procesado
        try {
            BufferedReader br = new BufferedReader(new FileReader(entrada)); // Lector del archivo de entrada
            FileWriter fw = new FileWriter(salida);                          // Escritor del archivo de salida
            String linea;
            // Lee línea a línea el archivo de entrada
            while ((linea = br.readLine()) != null) {
                linea = linea.trim(); // Elimina espacios en blanco al inicio y final
                if (linea.startsWith("AN")) { // Si la línea empieza por "AN", se considera un NSS
                    fw.write(linea + "\n");  // Escribe el NSS en el archivo de salida
                    contador++;               // Incrementa el contador de NSS
                }
            }
            fw.close(); // Cierra el escritor
            br.close(); // Cierra el lector
            System.out.println("COUNT:" + contador); // Imprime el número total de NSS encontrados
        } catch (IOException e) {
            // Si ocurre un error al leer o escribir archivos, imprime COUNT:0
            System.out.println("COUNT:0");
        }
    }
}
