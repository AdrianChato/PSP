package acceso.guzmanesSalud.services;

import java.util.List;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;


public interface PacientesService {

	List<Paciente> findAllPaciente();
	List<ConstantesVitales> findAllConstantesVitales();
	public Paciente findPacienteById(long id);
	public ConstantesVitales findConstantesVitalesById(long id);
	public Paciente crearPaciente (Paciente paciente);
	public ConstantesVitales crearConstantes (ConstantesVitales constantes);
	public Paciente agregarConstantesVitales(long id, ConstantesVitales constantes);
}
