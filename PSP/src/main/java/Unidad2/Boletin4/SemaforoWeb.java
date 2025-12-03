package Unidad2.Boletin4;

import java.util.concurrent.Semaphore;

public class SemaforoWeb {
	
	private Semaphore semaforo;

	public SemaforoWeb(int numeroConexiones) {
		semaforo = new Semaphore(numeroConexiones);
	}
	public void conexionPeticion() {
		try {
			semaforo.acquire();
			System.out.println(Thread.currentThread().getName() + " Esta dentro de la web");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName() + "Ya no esta dentro");
		}}
}


