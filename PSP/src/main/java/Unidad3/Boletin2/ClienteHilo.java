package Unidad3.Boletin2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteHilo extends Thread{
	
	public void run() {
		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int puerto = 5555;// puerto remoto en el servidor que el cliente conoce
		Socket cliente;
		try {
			cliente = new Socket(Host, puerto);
			System.out.println("Cliente : conexion establecida");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // conecta

	}
}
