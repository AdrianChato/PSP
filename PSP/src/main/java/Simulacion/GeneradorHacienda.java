package Simulacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GeneradorHacienda {
	
	private static final String RUTA = "src/main/resources/";
	private static final String rutaFicherosJava = "C:\\Users\\Chato\\Desktop\\Spring\\backup\\PSP\\src\\main\\java\\Simulacion";

    public static void main(String[] args) {
        try {
            BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Introduce el nombre del fichero (por ejemplo datos.txt): ");
            String nombreFichero = sc.readLine();

            // Ruta completa del archivo que se pasará a los hijos
            String rutaCompleta = System.getProperty("user.dir") + File.separator + RUTA + nombreFichero;

            // Ejecutar procesos
            int totalNSS = lanzarProceso("Simulacion.GenerarNSSFichero", rutaCompleta);
            int totalDNI = lanzarProceso("Simulacion.GenerarDNIFichero", rutaCompleta);

            // Crear resumen
            crearResumen(totalDNI, totalNSS);

            System.out.println("\nProcesamiento completado correctamente.");
            System.out.println("Consulta el fichero resumen.txt en la carpeta resources.");

        } catch (Exception e) {
            System.out.println("Error en el programa: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Método para lanzar un proceso hijo y devolver el número COUNT:x
    private static int lanzarProceso(String clase, String rutaEntrada) {
        int total = 0;
        try {
            String[] comando = { "java", "-cp", "\\target\\", rutaFicherosJava, rutaEntrada };
            ProcessBuilder pb = new ProcessBuilder(comando);

            // Mezclamos salida estándar y errores (para ver todo)
            pb.redirectErrorStream(true);

            Process proceso = pb.start();

            // Esperar a que termine
            int exitCode = proceso.waitFor();

            // Leer salida completa
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            String ultima = "";
            while ((linea = br.readLine()) != null) {
                System.out.println(clase + " -> " + linea); // Mostrar lo que dice el hijo
                ultima = linea; // guardamos la última línea
            }

            if (ultima.startsWith("COUNT:")) {
                total = Integer.parseInt(ultima.split(":")[1].trim());
            } else {
                System.out.println("⚠️  " + clase + " no devolvió COUNT:");
            }

            System.out.println(clase + " finalizó con código: " + exitCode);

        } catch (Exception e) {
            System.out.println("Error ejecutando " + clase + ": " + e.getMessage());
        }
        return total;
    }

    // Método para crear el resumen
    private static void crearResumen(int totalDNI, int totalNSS) {
        try {
            File resumen = new File(RUTA + "resumen.txt");
            FileWriter fw = new FileWriter(resumen);
            fw.write("Número total de contribuyentes tratados:\n");
            fw.write("DNIs Tratados: " + totalDNI + "\n");
            fw.write("NSSs Tratados: " + totalNSS + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al crear resumen: " + e.getMessage());
        }
    }
}