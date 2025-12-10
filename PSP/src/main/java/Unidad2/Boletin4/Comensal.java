package Unidad2.Boletin4;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable{

	private String nombre;
	private Semaphore hayPlato;
	private Semaphore hayCliente;
	
	

	public Comensal(String nombre, Semaphore hayPlato, Semaphore hayCliente) {
		super();
		this.nombre = nombre;
		this.hayPlato = hayPlato;
		this.hayCliente = hayCliente;
	}


	public void comer() {
		try {
			hayCliente.release();
			hayPlato.acquire(3);
			System.out.println(Thread.currentThread().getName() + " Esta comiendo");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		}


	@Override
	public void run() {
		comer();
	}

}
