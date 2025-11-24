package Unidad2.Boletin3;

public class GestionaMultiplosCoperativos {
	public static void main(String[] args) {
		long t_comienzo = System.currentTimeMillis();
		// Creo un sólo objeto MultiplosCooperativos 
		MultiplosCoperativos objetoMultiplo = new MultiplosCoperativos();
		try {
			// Creo un hilo de cada tipo
			MultiploCoperativo2 hilo2 = new MultiploCoperativo2(objetoMultiplo);
			MultiploCoperativo3 hilo3 = new MultiploCoperativo3(objetoMultiplo);
			MultiploCoperativo7 hilo7 = new MultiploCoperativo7(objetoMultiplo);
		
			hilo2.start(); 
			hilo3.start();
			hilo7.start();
			hilo2.join();
			hilo3.join();
			hilo7.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		long t_fin = System.currentTimeMillis();
		long tiempototal = t_fin - t_comienzo;
		System.out.println("El proceso total ha tardado= " + tiempototal + "mseg");
	}

}