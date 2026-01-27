package ejercicio4;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Hiloclientes implements Runnable {

    @Override
    public void run() {
        try (Socket socket = new Socket("localhost", 44444);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Leer ID
            String id = entrada.readLine();
            // System.out.println("Bot " + id + " conectado."); // Comentado para no ensuciar consola

            // Verificar estado
            String estado = entrada.readLine();
            if ("SIN_PREMIOS".equals(estado)) {
                return;
            }

            Random r = new Random();
            // El bot hace 3 intentos y se va
            for (int i = 0; i < 3; i++) {
                int f = r.nextInt(3);
                int c = r.nextInt(4);
                
                salida.println(f + "," + c);
                String respuesta = entrada.readLine();
                
                if (!respuesta.equals("SIN PREMIO") && !respuesta.startsWith("COORDENADAS")) {
                    System.out.println(">>> El Bot " + id + " encontró: " + respuesta + " en ["+f+","+c+"]");
                }
                
                Thread.sleep(500); // Espera un poco entre intentos
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}