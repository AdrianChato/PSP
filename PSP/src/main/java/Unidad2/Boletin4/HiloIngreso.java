package Unidad2.Boletin4;

public class HiloIngreso extends Thread{

	private Cuenta importeOperacion;
	private int aleatorio;

	public Cuenta getImporteOperacion() {
		return importeOperacion;
	}

	public void setImporteOperacion(Cuenta importeOperacion) {
		this.importeOperacion = importeOperacion;
	}

	public HiloIngreso(Cuenta importeOperacion) {
		super();
		this.importeOperacion = importeOperacion;
	}

	@Override
	public void run() {
		importeOperacion.ingresa(aleatorio);
	}
}
