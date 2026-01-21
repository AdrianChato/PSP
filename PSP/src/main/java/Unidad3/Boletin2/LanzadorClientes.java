package Unidad3.Boletin2;

public class LanzadorClientes {
		public static void main(String[] args) {
			for(int i = 0; i < 10; i++) {
				Thread hilo = new Thread(new ClienteHilo());
				hilo.start();
			}
			
			
		}
	}
