package boletin2.ejercicio4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 5555;
     // Contador para dar un número a cada cliente
        int id = 0;
     // Creamos un único tablero que compartirán todos los clientes
        Tablero tablero = new Tablero();
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);
         // El servidor siempre está esperando clientes
            while (true) {
                // Espera hasta que un cliente se conecte
                Socket socketCliente = servidor.accept();
                System.out.println("Cliente conenctado: IP=" + socketCliente.getInetAddress().getHostAddress() + 
                                   ", Puerto:" + socketCliente.getPort() + " " + new Date() );
                // Aumentamos el id para el nuevo cliente
                id++;
                // Creamos un hilo para atender a ese cliente
                new ManejadorHilosServidor(socketCliente,id, tablero).start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}