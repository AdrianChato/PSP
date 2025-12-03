package Unidad2.Boletin4;

import java.util.concurrent.Semaphore;

public class Comensal implements Runnable{

	private Semaphore semaforo;
	
	public Comensal(int num, String nombre) {
		super();
		this.semaforo = new Semaphore(num);
	}
	
	public Comensal(int num) {
		super();
		this.semaforo = new Semaphore(num);
	}

	public void comer() {
		try {
			semaforo.acquire();
			System.out.println(Thread.currentThread().getName() + " Esta comiendo");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}


	@Override
	public void run() {
		comer();
	}

}
