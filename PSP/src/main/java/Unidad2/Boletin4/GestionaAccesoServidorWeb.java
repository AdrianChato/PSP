package Unidad2.Boletin4;

import java.util.ArrayList;
import java.util.List;

public class GestionaAccesoServidorWeb {

	public static void main(String[] args) {
		SemaforoWeb semaforo = new SemaforoWeb(12);
		int numHilos = 20;
		
		List<Thread> hilos = new ArrayList<>();
		
		for(int i = 0; i < numHilos; i++)
		{
			hilos.add(new Thread(new PeticionWeb(semaforo, "hilo"+(i+1))));
		}		
		
		for(Thread hilo : hilos)
		{
			hilo.start();
		}		
	}}
