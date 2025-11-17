package Unidad2;

public class MiHilo2 implements Runnable{

	private String nombreHilo;
	
	
	
	public MiHilo2(String nombreHilo) {
		super();
		this.nombreHilo = nombreHilo;
	}



	@Override
	public void run() {
		Thread.currentThread().setName(nombreHilo);
		System.out.println("Ejecutando Hilo:"+Thread.currentThread().getName());		
	}


}
