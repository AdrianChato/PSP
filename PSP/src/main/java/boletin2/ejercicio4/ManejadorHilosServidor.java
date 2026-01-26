package boletin2.ejercicio4;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ManejadorHilosServidor extends Thread {
    private Socket socket;
    private Contador contador = new Contador();

    public ManejadorHilosServidor(Socket socket, Contador contador) {
        this.socket = socket;
        this.contador= contador;
    }

    @Override
    public void run() {
        String infoCliente = "IP=" + socket.getInetAddress().getHostAddress() + ", Puerto=" + socket.getPort();
        try (BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {
        	{
        		
                salida.println("Eres el cliente " + contador.getContador());
                contador.setContador(contador.getContador()+1);
            }

        } catch (IOException e) {
        } finally {
            System.out.println("cliente desconenctado: " + infoCliente + " " + new Date() );
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}