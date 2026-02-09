package Examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloCliente extends Thread {

	public void run() {
		String Host = "localhost"; 
		int puerto = 5555;
		Socket cliente;
		try (Socket socket = new Socket("localhost", puerto);
	             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
	             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	             BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {
				System.out.println("Cliente : conexion establecida");

	            System.out.println(entrada.readLine());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
