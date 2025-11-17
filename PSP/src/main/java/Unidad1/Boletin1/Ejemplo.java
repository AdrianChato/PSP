package Unidad1.Boletin1;

import java.io.IOException;

public class Ejemplo {

	public static void main(String[] args) throws InterruptedException {
		Runtime kernel = Runtime.getRuntime();
		
		System.out.println(kernel.freeMemory());
		System.out.println(kernel.maxMemory());
		System.out.println(kernel.totalMemory());
		String [] argumentos = {"Notepad"};
		String [] arg = {"C:\\Program Files\\MySQL\\MySQL Workbench 8.0\\MySQLWorkbench.exe"};
		try {
			Process proceso = kernel.exec(argumentos);
			int codigoretorno = proceso.waitFor();
			System.out.println("Final llego--- " + codigoretorno);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
