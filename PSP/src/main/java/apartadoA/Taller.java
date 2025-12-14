package apartadoA;

public class Taller {

    private int coches;

    public Taller(int coches) {
        this.coches = coches;
    }

    // Seccion critica, metodo sincronizado
    public synchronized boolean repararCoche() {
        if (coches > 0) {
            coches--;
            System.out.println("Coche reparado. Quedan: " + coches);
            return true;
        }
        return false;
    }
}

