package boletin2.ejercicio5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorHiloServidor extends Thread {

    private Socket socket;

    public ManejadorHiloServidor(Socket socket) {
        this.socket = socket;
    }

    public void run() {

        boolean par = socket.getPort() % 2 == 0;
        String tipo = par ? "PAR" : "IMPAR";

        try (
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true)
        ) {

            while (true) {

                if (Servidor.acertado) {
                    out.println("SERVIDOR (" + tipo + "): JUEGO TERMINADO");
                    break;
                }

                out.println("SERVIDOR (" + tipo + "): ENVIA NUMERO");
                int numero = Integer.parseInt(in.readLine());

                if (numero == Servidor.numeroSecreto) {
                    Servidor.acertado = true;
                    out.println("SERVIDOR (" + tipo + "): ACIERTO");
                    break;
                } else if (numero < Servidor.numeroSecreto) {
                    out.println("SERVIDOR (" + tipo + "): MAYOR");
                } else {
                    out.println("SERVIDOR (" + tipo + "): MENOR");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
