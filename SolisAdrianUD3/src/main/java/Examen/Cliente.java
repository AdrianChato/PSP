package Examen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {

		try (
				Socket socket = new Socket("localhost", 5555);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {

				String estado = in.readLine();
				String recibe = out.toString();

				System.out.println(estado);
				System.out.println(recibe.toString());
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
