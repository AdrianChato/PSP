package Unidad2.Boletin1;

public class GestionaHijos {
	
	public static void main(String[] args) {
		long inicioPadre = System.nanoTime();

        Hijo1 runnable1 = new Hijo1("hilo1");
        Hijo2 hijo2 = new Hijo2("hilo2");

        Thread hilo1 = new Thread(runnable1);
        hilo1.start();
        hijo2.start();

        long inicioEspera = System.nanoTime();

        try {
            hilo1.join();
            hijo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finPadre = System.nanoTime();

        long tiempoEjecucionPadre = inicioEspera - inicioPadre;
        long tiempoEsperaHijos = finPadre - inicioEspera;
        long tiempoTotal = finPadre - inicioPadre;

        System.out.println("⏱ Tiempo de ejecución del padre (antes de esperar): " + tiempoEjecucionPadre / 1_000_000 + " ms");
        System.out.println("⏳ Tiempo esperando a los hijos: " + tiempoEsperaHijos / 1_000_000 + " ms");
        System.out.println("🕒 Tiempo total del hilo padre: " + tiempoTotal / 1_000_000 + " ms");
    }
}

