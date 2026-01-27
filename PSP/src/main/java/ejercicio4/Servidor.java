package ejercicio4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 44444;
        int idCliente = 0; 
        Tablero tablero = new Tablero(); 

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            
            while (true) {
                Socket socketCliente = servidor.accept();
                idCliente++;
                System.out.println("Cliente conectado => " + idCliente);
                
                new ManejadorHilosServidor(socketCliente, tablero, idCliente).start();
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        }
    }
}