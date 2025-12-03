package Unidad2.Boletin4;

import java.util.concurrent.Semaphore;

public class Cocinero implements Runnable{

	private Semaphore semaforo;
	private int num;
	
	public Cocinero(String nombre, Semaphore semaforo) {
		super();
		this.semaforo = new Semaphore(num);
	}

	public void cocinar() {
		while (true) {
		try {
			System.out.println(Thread.currentThread().getName() + " Esta cocinando");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName() + "Ya ha cocinado");
		}}}

	@Override
		public void run() {
		cocinar();		
			}

}
