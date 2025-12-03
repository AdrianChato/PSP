package Unidad2.Boletin4;

public class PeticionWeb implements Runnable{

	private SemaforoWeb semaforo;
	private String nombre;
	
	
	public PeticionWeb(SemaforoWeb semaforo, String nombre) {
		super();
		this.semaforo = semaforo;
		this.nombre = nombre;
	}



	@Override
	public void run() {

		semaforo.conexionPeticion();
	}

}
