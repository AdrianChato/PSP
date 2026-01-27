package boletin2.ejercicio5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente extends Thread {

    private String fichero;
    private String tipo;

    public Cliente(String fichero, String tipo) {
        this.fichero = fichero;
        this.tipo = tipo;
    }

    public void run() {

        try (
            Socket socket = new Socket("localhost", 6666);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader file = new BufferedReader(
                    new FileReader(fichero))
        ) {

            String linea;
            while ((linea = in.readLine()) != null) {

                if (linea.contains("TERMINADO")) break;

                int numero = Integer.parseInt(file.readLine());
                out.println(numero);

                String respuesta = in.readLine();
                System.out.println("CLIENTE " + tipo + ": recibido -> " + respuesta);

                if (respuesta.contains("ACIERTO")) break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
