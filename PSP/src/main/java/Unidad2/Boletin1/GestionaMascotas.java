package Unidad2.Boletin1;

import java.util.ArrayList;
import java.util.List;

public class GestionaMascotas {

	public static void main(String[] args) {
		Mascota p = new Mascota("Lulu", 0);
		List <Thread> cuidadores = new ArrayList<Thread>();
		
		for (int i = 1; i <= 10; i++) {
			Thread cuidador = new Thread (p, "Cuidadores" +i);
			cuidadores.add(cuidador);
			cuidador.start();
			cuidador.setPriority((11 - i));
			
	
			for(Thread c : cuidadores)
			{
				try {
				c.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		
		System.out.println(p.getAlimentacion());

	}
	}
}

