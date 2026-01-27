package ejercicio5;

import java.io.*;
import java.net.Socket;

public class Hiloclientes implements Runnable {
    private String tipo;
    private String fichero;

    public Hiloclientes(String tipo, String fichero) {
        this.tipo = tipo;
        this.fichero = fichero;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 6666);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader lectorFichero = new BufferedReader(new FileReader(fichero))) {

            String numero;
            while ((numero = lectorFichero.readLine()) != null) {
                // Enviar número al servidor
                salida.println(numero);

                // Leer respuesta
                String respuesta = entrada.readLine();
                if (respuesta == null) break;

                System.out.println("CLIENTE " + tipo + ": recibido -> " + respuesta);

                // Si acertamos o el servidor nos avisa del fin, cerramos
                if (respuesta.equals("ACIERTO") || respuesta.contains("terminado")) {
                    break;
                }

                // Pausa para que el log sea legible
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("CLIENTE " + tipo + " error: " + e.getMessage());
        }
    }
}