package ejercicio5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6666;

        try (Socket socket = new Socket(host, puerto);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            System.out.println("--- BIENVENIDO AL JUEGO DEL NÚMERO SECRETO ---");
            System.out.println("Conectado al servidor. Intenta adivinar un número entre 0 y 20.");

            boolean terminado = false;
            while (!terminado) {
                System.out.print("Introduce tu número (o escribe -1 para rendirte): ");
                String lectura = sc.nextLine();

                if (lectura.equals("-1")) {
                    System.out.println("Te has rendido. Cerrando conexión...");
                    break;
                }

                // Enviar número al servidor
                salida.println(lectura);

                // Recibir respuesta
                String respuesta = entrada.readLine();
                
                if (respuesta == null) {
                    System.out.println("SERVIDOR: Conexión cerrada por el servidor.");
                    break;
                }

                System.out.println("SERVIDOR DICE: " + respuesta);

                // Analizar la respuesta para saber si continuar
                if (respuesta.equals("ACIERTO")) {
                    System.out.println("¡ENHORABUENA! Has ganado el juego.");
                    terminado = true;
                } else if (respuesta.contains("terminado")) {
                    System.out.println("El juego ya ha finalizado porque otro usuario acertó.");
                    terminado = true;
                }
            }

        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        
        System.out.println("Fin de la aplicación cliente.");
    }
}