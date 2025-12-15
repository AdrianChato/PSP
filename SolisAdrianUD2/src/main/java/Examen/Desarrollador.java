package Examen;

import java.util.concurrent.Semaphore;

public class Desarrollador implements Runnable{

	private String id;
	private EntornoCloud inicio_sesion;
	private Semaphore semaforo;
	

	public Desarrollador(String id, EntornoCloud inicio_sesion) {
		super();
		this.id = id;
		this.inicio_sesion = inicio_sesion;
	}


	@Override
	public void run() {
		inicio_sesion.inicia_sesion();
		inicio_sesion.autentificacion();
	}
	
	
}
