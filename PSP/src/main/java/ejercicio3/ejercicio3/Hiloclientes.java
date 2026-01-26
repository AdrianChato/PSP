package ejercicio3.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Hiloclientes extends Thread {

	public void run() {
		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int puerto = 44444;// puerto remoto en el servidor que el cliente conoce
		Socket cliente;
		try (Socket socket = new Socket("localhost", 44444);
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
