package Examen;

import java.util.concurrent.Semaphore;


public class GestionaSesionesCloud {

	public static void main(String[] args) {
		
		Semaphore semaforo1 = new Semaphore(20);
		Semaphore semaforo2 = new Semaphore(8);
		

		EntornoCloud entorno = new EntornoCloud(35, TipoEntorno.EDF, semaforo1);
		EntornoCloud entorno2 = new EntornoCloud(15, TipoEntorno.EPP, semaforo2);
		
		
		for (int i = 1; i <=20; i++) {
			Desarrollador des1 = new Desarrollador("prueba", entorno2);
			Thread hiloEDF = new Thread(des1);
			hiloEDF.start();
		}
		
		for (int i = 1; i <=8; i++) {
			Desarrollador des2 = new Desarrollador("prueba", entorno);
			Thread hiloEDP = new Thread(des2);
			hiloEDP.start();
		}
		

		
		
	}

}
