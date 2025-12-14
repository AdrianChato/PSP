package apartadoB;

import java.util.concurrent.Semaphore;

public class Taller {

    private int coches;
    private Semaphore semaforo;

    public Taller(int coches) {
        this.coches = coches;
        // Semáforo con 1 permiso → exclusión mutua
        this.semaforo = new Semaphore(1);
    }

    public boolean repararCoche(String nombre) {
        try {
            semaforo.acquire(); // entra en seccion critica

            if (coches > 0) {
                coches--;
                System.out.println(nombre + " repara un coche. Quedan: " + coches);
                return true;
            }
            return false;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;

        } finally {
            semaforo.release(); // sale de seccion critica
        }
    }
}
