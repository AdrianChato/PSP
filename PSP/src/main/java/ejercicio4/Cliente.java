package ejercicio4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 44444);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner sc = new Scanner(System.in)) {

            // 1. Leer ID
            String id = entrada.readLine();
            System.out.println("Soy el cliente ID: " + id);

            // 2. Comprobar estado del juego
            String estado = entrada.readLine();
            if ("SIN_PREMIOS".equals(estado)) {
                System.out.println("Ya no quedan premios. Fin de la conexión.");
                return;
            }

            System.out.println("¡Empieza el juego! Introduce fila (0-2) y columna (0-3).");
            System.out.println("Escribe '-1' para salir.");

            while (true) {
                System.out.print("Introduce Fila: ");
                String fila = sc.nextLine();
                if (fila.equals("-1")) break;

                System.out.print("Introduce Columna: ");
                String col = sc.nextLine();
                
                // Enviar al servidor formato "F,C"
                salida.println(fila + "," + col);

                // Leer respuesta
                String respuesta = entrada.readLine();
                System.out.println("Servidor dice: " + respuesta);

                if (!respuesta.equals("SIN PREMIO") && !respuesta.startsWith("ERROR") && !respuesta.startsWith("COORDENADAS")) {
                    System.out.println("¡FELICIDADES! Has ganado: " + respuesta);
                    // Opcional: salir si gana
                    // break; 
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}