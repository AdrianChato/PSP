package Unidad2.Boletin4;

public class GestionaCuentaBanco {

	public static void main(String[] args) throws InterruptedException {
		Cuenta cuentaBanco = new Cuenta();
		
		HiloIngreso h1 = new HiloIngreso(cuentaBanco);
		HiloIngreso h2 = new HiloIngreso(cuentaBanco);
		HiloRetira h3 = new HiloRetira(cuentaBanco);
		HiloRetira h4 = new HiloRetira(cuentaBanco);
		
		h1.start();
		h1.join();
		System.out.println(cuentaBanco.getSueldoActual());
		h2.start();
		h2.join();
		System.out.println(cuentaBanco.getSueldoActual());
		h3.start();
		h3.join();
		System.out.println(cuentaBanco.getSueldoActual());
		h4.start();
		h4.join();
		
		
		System.out.println(cuentaBanco.getSueldoActual());

	}

}
