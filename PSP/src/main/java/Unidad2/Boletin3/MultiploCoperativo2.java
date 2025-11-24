package Unidad2.Boletin3;

public class MultiploCoperativo2 extends Thread{

	private MultiplosCoperativos multiplo;

	
	
	public MultiploCoperativo2(MultiplosCoperativos multiplo) {
		super();
		this.multiplo = multiplo;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		multiplo.multiplicar(2);
		
	}
	
	
}
