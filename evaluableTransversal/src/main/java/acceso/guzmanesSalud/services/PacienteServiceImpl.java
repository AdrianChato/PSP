package acceso.guzmanesSalud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.repositories.ConstantesVitalesRepository;
import acceso.guzmanesSalud.repositories.PacienteRepository;
import exceptions.PacienteNotFoundException;

@Service
public class PacienteServiceImpl implements PacientesService{
	
	@Autowired
	private PacienteRepository pacienteRepo;
	@Autowired
	private ConstantesVitalesRepository constantesRepo;
	@Override
	public List<Paciente> findAllPaciente() {
		return pacienteRepo.findAll();
	}
	@Override
	public List<ConstantesVitales> findAllConstantesVitales() {
		return constantesRepo.findAll();
	}
	@Override
	public Paciente findPacienteById(long id) {
		return pacienteRepo.findPacienteByIdPaciente(id);
	}
	@Override
	public Paciente crearPaciente(Paciente paciente) {
		return pacienteRepo.save(paciente);
	}
	@Override
	public Paciente agregarConstantesVitales(long id, ConstantesVitales constantes) {

		Paciente paciente = this.findPacienteById(id);
		ConstantesVitales constantesori;
		
		if (constantes.getIdConstantes() != null) {
			constantesori = constantesRepo.findById(constantes.getIdConstantes())
					.orElseThrow(() -> new PacienteNotFoundException("No se ha encontrado pacientes"));
		} else {
			constantesori = constantesRepo.save(constantes);
		}
		if (!paciente.getConstantesVitales().contains(constantesori)) {
			paciente.getConstantesVitales().add(constantesori);
			constantesori.setPaciente(paciente);
		}
		return paciente;
	}
	@Override
	public ConstantesVitales findConstantesVitalesById(long id) {
		return constantesRepo.findConstantesVitalesByIdConstantes(id);
	}
	@Override
	public ConstantesVitales crearConstantes(ConstantesVitales constantes) {
		return constantesRepo.save(constantes);
	}

	

}
