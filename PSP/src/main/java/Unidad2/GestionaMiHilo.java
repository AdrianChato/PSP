package Unidad2;

public class GestionaMiHilo {

	public static void main(String[] args) {
		/*MiHilo hilo1 = new MiHilo("Hilo1");
		System.out.println(hilo1.getState());
		
		hilo1.start();
		System.out.println(hilo1.getState());

		
		MiHilo hilo2 = new MiHilo("Hilo2");
		
		hilo2.start();
		
		System.out.println("En el main");
		System.out.println(hilo1.getState());*/ //Heredado de Thread
		
		MiHilo2 hilo1 = new MiHilo2("Hilo 1");
		
		MiHilo2 hilo2 = new MiHilo2("Hilo 2");
		System.out.println("Hilo principal terminado");
	}


	}

