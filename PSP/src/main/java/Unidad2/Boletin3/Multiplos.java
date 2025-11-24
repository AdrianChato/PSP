package Unidad2.Boletin3;

public class Multiplos implements Runnable{

	private int num;
	
	public Multiplos(int num) {
		super();
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.multiplicar();
	}

	public void multiplicar() {
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
