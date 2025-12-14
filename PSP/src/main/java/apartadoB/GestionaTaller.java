package apartadoB;

public class GestionaTaller {

    public static void main(String[] args) throws InterruptedException {

        Taller taller = new Taller(20);

        Thread mecanico1 = new Thread(
                new Mecanico(taller, 5000, "Mecánico 1"));
        Thread mecanico2 = new Thread(
                new Mecanico(taller, 8000, "Mecánico 2"));

        long inicio = System.currentTimeMillis();

        mecanico1.start();
        mecanico2.start();

        mecanico1.join();
        mecanico2.join();

        long fin = System.currentTimeMillis();

        System.out.println("Tiempo total: " + (fin - inicio) / 1000 + " segundos");
    }
}
