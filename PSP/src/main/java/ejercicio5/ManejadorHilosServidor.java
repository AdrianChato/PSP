package ejercicio5;

import java.io.*;

import java.net.Socket;



public class ManejadorHilosServidor extends Thread {
    private Socket socket;
    private String tipo;

    public ManejadorHilosServidor(Socket socket, String tipo) {
        this.socket = socket;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try (PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String linea;
            while ((linea = entrada.readLine()) != null) {
                // Comprobamos si alguien ya acertó antes de procesar el número
                if (Servidor.adivinado) {
                    salida.println("SERVIDOR (" + tipo + "): El juego ha terminado, otro cliente acertó.");
                    break;
                }

                try {
                    int intento = Integer.parseInt(linea);
                    
                    // Lógica de comparación
                    if (intento == Servidor.numeroSecreto) {
                        Servidor.adivinado = true;
                        salida.println("ACIERTO");
                        System.out.println("SERVIDOR (" + tipo + "): ¡Han acertado el número " + Servidor.numeroSecreto + "!");
                        break; 
                    } else if (intento < Servidor.numeroSecreto) {
                        salida.println("MAYOR");
                        System.out.println("SERVIDOR (" + tipo + "): recibió " + intento + ", respuesta: MAYOR");
                    } else {
                        salida.println("MENOR");
                        System.out.println("SERVIDOR (" + tipo + "): recibió " + intento + ", respuesta: MENOR");
                    }

                } catch (NumberFormatException e) {
                    salida.println("ERROR: Envía un número válido.");
                }
            }
        } catch (IOException e) {
            // Manejo silencioso de desconexión
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}