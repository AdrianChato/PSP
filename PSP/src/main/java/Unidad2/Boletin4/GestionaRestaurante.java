package Unidad2.Boletin4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class GestionaRestaurante {
	public static void main(String[] args) {
		List<Thread> hilos = new ArrayList<>();
		//Semaphore semaforo = new Semaphore(3);
		//Cocinero cocinero = new Cocinero(3);
		
		//for(int i = 0; i < numHilos; i++)
		{
			//hilos.add(new Thread(new Comensal(semaforo, "hilo"+(i+1))));
		}		
		
		for(Thread hilo : hilos)
		{
			hilo.start();
		}		
	}}
