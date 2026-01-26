package boletin2.ejercicio4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {
    public static void main(String[] args) {
        int puerto = 44444;
        Contador contador = new Contador();
        try (ServerSocket servidor = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);
            while (true) {
                Socket socketCliente = servidor.accept();
                System.out.println("Cliente conenctado: IP=" + socketCliente.getInetAddress().getHostAddress() + 
                                   ", Puerto:" + socketCliente.getPort() + " " + new Date() );
                new ManejadorHilosServidor(socketCliente, contador).start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}