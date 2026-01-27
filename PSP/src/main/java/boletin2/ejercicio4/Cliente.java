package boletin2.ejercicio4;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		try (
				// Conexión con el servidor
				Socket socket = new Socket("localhost", 5555);

				// Para leer mensajes del servidor
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				// Para enviar mensajes al servidor
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

				// Para leer datos del teclado
				Scanner sc = new Scanner(System.in)) {

			// Mostramos el ID que envía el servidor
			System.out.println(in.readLine());

			// Leemos si quedan premios
			String estado = in.readLine();

			if (estado.equals("NO_QUEDAN_PREMIOS")) {
				System.out.println("No quedan premios. Fin del juego.");
				return;
			}

			// Mientras el cliente quiera jugar
			while (true) {
				System.out.print("Introduce fila y columna (ej: 1,2): ");
				String jugada = sc.nextLine();

				// Enviamos la jugada al servidor
				out.println(jugada);

				// Mostramos la respuesta del servidor
				System.out.println("Servidor: " + in.readLine());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}