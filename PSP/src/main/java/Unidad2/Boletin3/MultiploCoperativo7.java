package Unidad2.Boletin3;

public class MultiploCoperativo7 extends Thread{
private MultiplosCoperativos multiplo;

	
	
	public MultiploCoperativo7(MultiplosCoperativos multiplo) {
		super();
		this.multiplo = multiplo;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		multiplo.multiplicar(7);
		
	}
	
	
}
