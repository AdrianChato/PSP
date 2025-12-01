package Unidad2.Boletin4;

public class Cuenta {

	private int sueldoActual;

	public int getSueldoActual() {
		return sueldoActual;
	}

	public void setSueldoActual(int sueldoActual) {
		this.sueldoActual = sueldoActual;
	}

	public Cuenta() {
		super();
		this.sueldoActual = sueldoActual;
	}
	
	public synchronized void retira(int num) throws BancoExcepcion {
		num = (int)(Math.random()*500+1);
		if ((sueldoActual - num) <= 0) {
			throw new BancoExcepcion("A la mierda");
		}else {
			sueldoActual = sueldoActual - num;
		}
		System.out.println("Retira " + num);
	}
	
	public synchronized void ingresa(int num) {
		num = (int)(Math.random()*500+1);
		sueldoActual = sueldoActual + num;
		System.out.println("Ingresa " + num);
	} 
}
