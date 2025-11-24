package Unidad2.Boletin3;

public class MultiploCoperativo3 extends Thread{
private MultiplosCoperativos multiplo;

	
	
	public MultiploCoperativo3(MultiplosCoperativos multiplo) {
		super();
		this.multiplo = multiplo;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		multiplo.multiplicar(3);
		
	}
	
	
}

