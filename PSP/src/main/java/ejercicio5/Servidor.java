package ejercicio5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static int numeroSecreto;
    public static volatile boolean adivinado = false;

    public static void main(String[] args) {
        int puerto = 6666;
        int contadorClientes = 0;
        numeroSecreto = (int) (Math.random() * 21);
        System.out.println("SERVIDOR: Número secreto -> " + numeroSecreto);

        try (ServerSocket servidor = new ServerSocket(puerto)) {
            while (true) {
                Socket socketCliente = servidor.accept();
                contadorClientes++;

                // Determinamos el tipo ANTES de crear el hilo
                String tipo;
                if (contadorClientes % 2 != 0) {
                    tipo = "IMPAR";
                } else {
                    tipo = "PAR";
                }
                // Inyectamos el tipo directamente al constructor
                new ManejadorHilosServidor(socketCliente, tipo).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}