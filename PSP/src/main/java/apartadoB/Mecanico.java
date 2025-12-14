package apartadoB;

public class Mecanico implements Runnable {

    private Taller taller;
    private int tiempo;
    private String nombre;

    public Mecanico(Taller taller, int tiempo, String nombre) {
        this.taller = taller;
        this.tiempo = tiempo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (taller.repararCoche(nombre)) {
            try {
                Thread.sleep(tiempo); // Tiempo distinto según mecánico
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
