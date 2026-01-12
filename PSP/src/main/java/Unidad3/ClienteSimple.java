package Unidad3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteSimple {

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
			boolean acaba = false;
			while (!acaba) {
				Scanner sc = new Scanner(System.in);
				mensajeParaServidor = sc.nextLine();
				salida.println(mensajeParaServidor);
				if (mensajeParaServidor.equals("fin")) {
					acaba = true;
				}
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
