package Unidad2.Boletin1;

import java.io.File;

public class RecorreFicheros implements Runnable{

	private File fichero;
	private int numCaracteres;
	public File getFichero() {
		return fichero;
	}
	public void setFichero(File fichero) {
		this.fichero = fichero;
	}
	public int getNumCaracteres() {
		return numCaracteres;
	}
	public void setNumCaracteres(int numCaracteres) {
		this.numCaracteres = numCaracteres;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
