package Examen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ManejadorHiloServidor extends Thread {
    private Socket socket;
    private int id;
    Servidor servidor = new Servidor();
    
    
    public ManejadorHiloServidor(Socket socket, int id) {
		super();
		this.socket = socket;
		this.id = id;
	}


	@Override
	public void run() {
        System.out.println("Cliente conectado => " + id);

        try (
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true)
        ) {
            out.println("ID:" + id);
            servidor.colocarDatos();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Avisamos cuando el cliente se va
        System.out.println("Cliente desconectado => " + id);
    }
	
}
