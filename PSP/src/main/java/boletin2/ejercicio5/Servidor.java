package boletin2.ejercicio5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

import boletin2.ejercicio5.ManejadorHiloServidor;

public class Servidor {

    public static int numeroSecreto;
    public static boolean acertado = false;

    public static void main(String[] args) {

        int puerto = 6666;
        numeroSecreto = new Random().nextInt(21);

        try (ServerSocket servidor = new ServerSocket(puerto)) {

            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                Socket socketCliente = servidor.accept();
                System.out.println(
                        "Cliente conectado: IP=" +
                        socketCliente.getInetAddress().getHostAddress() +
                        ", Puerto:" + socketCliente.getPort() +
                        " " + new Date());

                new ManejadorHiloServidor(socketCliente).start();
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
