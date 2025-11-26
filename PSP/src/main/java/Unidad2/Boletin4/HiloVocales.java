package Unidad2.Boletin4;

public class HiloVocales extends Thread {

	private CuentaVocales cuentaVocales;
	private String vocal;
	private int numVocales;

	public CuentaVocales getCuentaVocales() {
		return cuentaVocales;
	}

	public void setCuentaVocales(CuentaVocales cuentaVocales) {
		this.cuentaVocales = cuentaVocales;
	}

	public String getVocal() {
		return vocal;
	}

	public void setVocal(String vocal) {
		this.vocal = vocal;
	}

	public int getNumVocales() {
		return numVocales;
	}

	public void setNumVocales(int numVocales) {
		this.numVocales = numVocales;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}

}
