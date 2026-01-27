package boletin2.ejercicio5;

public class LanzadorClientes {
	public static void main(String[] args) {

        Cliente par = new Cliente("par.txt", "PAR");
        Cliente impar = new Cliente("impar.txt", "IMPAR");

        par.start();
        impar.start();
    }
}