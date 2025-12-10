package Unidad2.Boletin4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante {
	public static void main(String[] args) {

		Semaphore hayClientes = new Semaphore(1);
		Semaphore hayPlato = new Semaphore(3);


		try {
			hayClientes.acquire();
			hayPlato.acquire(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Cocinero cocinero = new Cocinero(hayClientes, hayPlato, "Pepe");
		Thread hiloCocinero = new Thread(cocinero);
		
		hiloCocinero.start();
		
		for (int i = 1; i <=7; i++) {
			Comensal cliente = new Comensal("Juan", hayPlato, hayClientes);
			Thread HiloComensal = new Thread(cliente);
			HiloComensal.start();
		}
}}