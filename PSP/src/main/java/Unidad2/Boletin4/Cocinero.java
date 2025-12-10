package Unidad2.Boletin4;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable{

	private Semaphore hayComensal;
	private Semaphore hayPlato;
	private String nombre;
	
	

	

	public Cocinero(Semaphore hayComensal, Semaphore hayPlato, String nombre) {
		super();
		this.hayComensal = hayComensal;
		this.hayPlato = hayPlato;
		this.nombre = nombre;
	}

	public void cocinar() {
		while (true) {
		try {
			hayComensal.acquire();
			System.out.println(Thread.currentThread().getName() + " Esta cocinando");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			hayPlato.release(3);
			System.out.println(Thread.currentThread().getName() + "Ya ha cocinado");
		}}}

	@Override
		public void run() {
		cocinar();		
			}

}
