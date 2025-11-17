package Unidad2.Boletin1;

public class Mascota implements Runnable{
	
	private String nombre;
	private int alimentacion;
	
	
	
	public Mascota(String nombre, int alimentacion) {
		super();
		this.nombre = nombre;
		this.alimentacion = alimentacion;
	}

	public Mascota() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(int alimentacion) {
		this.alimentacion = alimentacion;
	}

	@Override
	public void run() {
		try {
			System.out.println(this.getNombre() + "ha comenzado a comer" + Thread.currentThread().getName());
			this.comer();
			Thread.sleep(1000);
			System.out.println("La mascota" + this.getNombre() + "Ha terminado de comer" + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void comer () {
		this.alimentacion+=1;
	}
}
