package Unidad2.Boletin1;

public class Hijo2 extends Thread{

	private String nombreHilo;

    public Hijo2(String nombreHilo) {
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Procesos");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombreHilo + " terminado");
    }
}
