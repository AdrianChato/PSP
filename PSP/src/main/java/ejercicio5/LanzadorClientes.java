package ejercicio5;

public class LanzadorClientes {
    public static void main(String[] args) {
    	String rutaBase = "src/main/resources/";
        // Creamos las tareas Runnable con sus ficheros
    	Hiloclientes tareaPar = new Hiloclientes("PAR", rutaBase + "par.txt");
        Hiloclientes tareaImpar = new Hiloclientes("IMPAR", rutaBase + "impar.txt");
        // Creamos los hilos conductores
        Thread hiloPar = new Thread(tareaPar);
        Thread hiloImpar = new Thread(tareaImpar);

        System.out.println("LANZADOR: Iniciando competición de adivinanza...");
        
        // Lanzamos ambos para ejecución concurrente
        hiloPar.start();
        hiloImpar.start();
    }
}