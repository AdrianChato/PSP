package Unidad2.Boletin3;

public class MultiplosCoperativos {

	public void multiplicar(int num) {
		for (int i= 0; i < 10; i++) {
			System.out.println(i*num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
