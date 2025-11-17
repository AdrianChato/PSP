package Unidad2.Boletin1;

public class Hijo1 implements Runnable{

	private String nombreHilo;

    public Hijo1(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Servicios");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombreHilo + " terminado");
    }
}

	
