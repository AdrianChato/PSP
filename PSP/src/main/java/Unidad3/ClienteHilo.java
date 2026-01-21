package Unidad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteHilo{
	String Host = "localhost";
	int Puerto = 5555;
	Socket cliente;
	
	try {
		cliente = new Socket(Host, Puerto);
		System.out.println("Cliente: Conexion establecida");
		
		//Configura flujos para enviar y recibir datos
		PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
		BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

		
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException t) {
		// TODO Auto-generated catch block
		t.printStackTrace();
	}//conecta
	
}
