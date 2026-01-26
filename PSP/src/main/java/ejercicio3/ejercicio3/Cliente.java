package ejercicio3.ejercicio3;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 44444);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Cliente : conexion establecida");

            System.out.println(entrada.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}