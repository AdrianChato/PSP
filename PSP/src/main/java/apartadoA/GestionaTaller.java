package apartadoA;

public class GestionaTaller {

    public static void main(String[] args) throws InterruptedException {

        Taller taller = new Taller(20);
        Thread mecanico = new Thread(new Mecanico(taller));

        long inicio = System.currentTimeMillis();

        mecanico.start();
        mecanico.join(); // El hilo principal espera al mecánico

        long fin = System.currentTimeMillis();

        System.out.println("Tiempo total: " + (fin - inicio) / 1000 + " segundos");
    }
}
