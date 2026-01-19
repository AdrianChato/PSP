package Unidad3.Boletin1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio3Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int puerto = 6000;
		ServerSocket servidor = null;
		Socket clienteConectado = null;
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Servidor escuchando en el puerto " + puerto);
			Socket cliente = servidor.accept();
			BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
			String mensaje = entrada.readLine();
			System.out.println("Servidor: Cliente dice: " + mensaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
