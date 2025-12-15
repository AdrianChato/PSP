package Examen;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class EntornoCloud{

	private int aforo;
	private TipoEntorno entorno;
	private Semaphore inicio_sesion;
	
	
	public EntornoCloud(int aforo, TipoEntorno entorno, Semaphore inicio_sesion) {
		super();
		this.aforo = aforo;
		this.entorno = entorno;
		this.inicio_sesion = inicio_sesion;
	}
	public void inicia_sesion () {
		try {
			inicio_sesion.acquire();
			System.out.println("Estan iniciando sesion");
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			inicio_sesion.release();
			System.out.println("Ya no esta iniciando sesion");
		}
		
	}
	
	public void autentificacion () {
		Random r = new Random();
		int aleatorio = r.nextInt(10)+1;
		int tiempo = r.nextInt(6)+1;
		if (aleatorio <= 5) {
			System.out.println("No puede iniciar sesion, tiene que esperar a las otras sesiones");
			try {
				Thread.sleep(tiempo*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	}
	
