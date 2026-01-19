package Unidad3.Boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejercicio3Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Host = "localhost"; //host servidor con el que el cliente quiere conectarse
		int Puerto = 6000;//puerto remoto en el servidor que el cliente conoce         
		Socket cliente;
		try {
			cliente = new Socket(Host, Puerto);
			System.out.println("Cliente: Conexion establecida");
			
			//Configura flujos para enviar y recibir datos
			PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
			//Envia mensaje al servidor
			String mensajeParaServidor = "hola";
			while ((mensajeParaServidor = entrada.readLine()) != null && !mensajeParaServidor.equalsIgnoreCase("fin")) {
				System.out.println("Cliente dice: " + mensajeParaServidor);
				salida.println("Servidor responde: " + mensajeParaServidor.toUpperCase());
		}
		if (mensajeParaServidor != null && mensajeParaServidor.equalsIgnoreCase("fin")) {
			salida.println("Cerrando sesión. ¡Hasta pronto!"); 			
	}

			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//conecta

		

	}

}

