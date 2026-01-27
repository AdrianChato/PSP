package ejercicio4;

public class LanzadorClientes {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			Thread hilo = new Thread(new Hiloclientes());
			hilo.start();
		}
		
		
	}
}
