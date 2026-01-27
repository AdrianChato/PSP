package ejercicio4conMapa;

import java.io.*;
import java.net.Socket;

public class ManejadorHilosServidor extends Thread {
    private Socket socket;
    private Tablero tablero;
    private int id;

    public ManejadorHilosServidor(Socket socket, Tablero tablero, int id) {
        this.socket = socket;
        this.tablero = tablero;
        this.id = id;
    }

    @Override
    public void run() {
        try (PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // 1. Enviar ID al cliente
            salida.println(id);

            // 2. Verificar si puede jugar
            if (!tablero.quedanPremios()) {
                salida.println("SIN_PREMIOS"); // Protocolo: No se puede jugar
                return; // Cierra conexión
            } else {
                salida.println("JUGAR"); // Protocolo: El juego comienza
            }

            // 3. Bucle de juego
            String inputLine;
            while ((inputLine = entrada.readLine()) != null) {
                // El cliente envía "FILA,COLUMNA" (ej: "1,2")
                try {
                    String[] partes = inputLine.split(",");
                    int f = Integer.parseInt(partes[0]);
                    int c = Integer.parseInt(partes[1]);

                    // Consultar al tablero (Sync)
                    String resultado = tablero.buscarPremio(f, c);
                    
                    // Responder al cliente
                    salida.println(resultado);

                    // Opcional: Si encuentra premio, podríamos desconectarlo o dejarle seguir
                    // Según lógica habitual, si acierta se le notifica.
                    
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    salida.println("ERROR: Formato debe ser F,C");
                }
            }

        } catch (IOException e) {
            // Cliente se desconectó abruptamente
        } finally {
            System.out.println("Cliente desconectado => " + id);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}