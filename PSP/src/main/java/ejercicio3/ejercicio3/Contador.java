package ejercicio3.ejercicio3;

public class Contador {
	public int contador;

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	public Contador() {
		super();
		this.contador = 1;
	}

	@Override
	public String toString() {
		return "Contador [contador=" + contador + "]";
	}
	
	
	

}
