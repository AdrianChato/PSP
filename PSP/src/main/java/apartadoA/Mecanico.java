package apartadoA;

public class Mecanico implements Runnable {

    private Taller taller;

    public Mecanico(Taller taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        while (taller.repararCoche()) {
            try {
                Thread.sleep(5000); // Simula 5 segundos de reparación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
