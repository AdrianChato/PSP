package boletin2.ejercicio4;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ManejadorHilosServidor extends Thread {
    // Socket para comunicarse con el cliente
    private Socket socket;
    // Número identificador del cliente
    private int id;
    // Tablero compartido por todos los clientes
    private Tablero tablero = new Tablero();

    
    // Constructor: guarda los datos del cliente
    public ManejadorHilosServidor(Socket socket, int id, Tablero tablero) {
		super();
		this.socket = socket;
		this.id = id;
		this.tablero = tablero;
	}



	@Override
	public void run() {

        // Avisamos por consola que el cliente se ha conectado
        System.out.println("Cliente conectado => " + id);

        try (
            // Para leer lo que envía el cliente
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Para enviar mensajes al cliente
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true)
        ) {

            // Enviamos el ID al cliente nada más conectarse
            out.println("ID:" + id);

            // Si no quedan premios, avisamos y cerramos conexión
            if (!tablero.quedanPremios()) {
                out.println("NO_QUEDAN_PREMIOS");
                socket.close();
                return;
            } else {
                // Si quedan premios, el cliente puede jugar
                out.println("HAY_PREMIOS");
            }

            String mensaje;

            // Leemos jugadas del cliente
            while ((mensaje = in.readLine()) != null) {

                // Quitamos espacios por si escriben "1, 2"
                mensaje = mensaje.replace(" ", "");

                String[] datos = mensaje.split(",");

                int fila = Integer.parseInt(datos[0]);
                int columna = Integer.parseInt(datos[1]);

                // Comprobamos que estén dentro del tablero
                if (fila < 1 || fila > 3 || columna < 1 || columna > 4) {
                    out.println("POSICION_FUERA_DEL_TABLERO");
                    continue;
                }

                // Pasamos a índices de array
                fila--;
                columna--;

                String premio = tablero.comprobar(fila, columna);

                if (premio != null) {
                    out.println("PREMIO: " + premio);
                } else {
                    out.println("SIN_PREMIO");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Avisamos cuando el cliente se va
        System.out.println("Cliente desconectado => " + id);
    }
}