package Unidad1.Boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzadorProvincias {
	
    private static final String CLASSES_DIR = "target/classes";
    private static final String JAVA_SRC = "src/main/java/";

    public void compila() {
        String[] comando = { "javac", "-d", CLASSES_DIR,
                JAVA_SRC + "Unidad1/Boletin1/SeparadorPorProvincias.java" };

        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String ejecuta(String fichero, String provincia) {
        String[] comando = { "java", "-cp", CLASSES_DIR,
                "Unidad1/Boletin1/SeparadorPorProvincias.java", fichero, provincia };

        StringBuilder salida = new StringBuilder();

        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while ((linea = br.readLine()) != null) {
                salida.append(linea).append("\n");
            }
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return salida.toString().trim();
    }

    public static void main(String[] args) {
        LanzadorProvincias lanzador = new LanzadorProvincias();
        lanzador.compila();

        String fichero = "pedidos.txt";
        String[] provincias = { "Sevilla", "Cádiz", "Almería", "Córdoba", "Jaén", "Málaga", "Huelva", "Granada" };

        int total = 0;

        for (String provincia : provincias) {
            String salida = lanzador.ejecuta(fichero, provincia);
            System.out.println(salida);

            // Extraer número de pedidos
            if (salida.contains(":")) {
                try {
                    int num = Integer.parseInt(salida.split(":")[1].trim());
                    total += num;
                } catch (NumberFormatException ignored) {}
            }
        }

        System.out.println("Nº total de Pedidos : " + total);
    }
}
