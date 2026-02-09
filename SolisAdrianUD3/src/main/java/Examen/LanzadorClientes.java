package Examen;


public class LanzadorClientes {
	public static void main(String[] args) {
		for(int i = 0; i < 9; i++) {
			Thread hilo = new Thread(new HiloCliente());
			hilo.start();
			try {
				hilo.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}}