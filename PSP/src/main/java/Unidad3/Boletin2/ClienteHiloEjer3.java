package Unidad3.Boletin2;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteHiloEjer3 extends Thread{
	
	public void run() {
		String Host = "localhost"; // host servidor con el que el cliente quiere conectarse
		int puerto = 44444;// puerto remoto en el servidor que el cliente conoce
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