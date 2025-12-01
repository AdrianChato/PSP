package Unidad2.Boletin4;

public class HiloRetira extends Thread{

	private Cuenta importeOperacion;
	private int aleatorio;

	public Cuenta getImporteOperacion() {
		return importeOperacion;
	}

	public void setImporteOperacion(Cuenta importeOperacion) {
		this.importeOperacion = importeOperacion;
	}

	public HiloRetira(Cuenta importeOperacion) {
		super();
		this.importeOperacion = importeOperacion;
	}

	@Override
	public void run() {
		try {
			importeOperacion.retira(aleatorio);
		} catch (BancoExcepcion e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());		}
	}

	
	
	
}
