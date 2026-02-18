package acceso.guzmanesSalud.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.models.Response;
import acceso.guzmanesSalud.services.PacientesService;
import exceptions.PacienteNotFoundException;

@Controller
@RequestMapping("/salud")
public class SaludController {
	
	@Autowired
	private PacientesService pacienteService;
	
	@ExceptionHandler(PacienteNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(PacienteNotFoundException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		return "detalle";
	}
	
	@PostMapping("/paciente")
	public ResponseEntity<Paciente> addVacuna(@RequestBody Paciente paciente) {
		Paciente addedPaciente = pacienteService.crearPaciente(paciente);
		return new ResponseEntity<>(addedPaciente, HttpStatus.CREATED);
	}
	
	@PostMapping("/agregaConstantes/{idPaciente}")
	@ResponseBody
	public Map<String, Object> addConstantePaciente(@PathVariable Long idPaciente, @RequestBody ConstantesVitales constantes) {
		Map<String, Object> respuesta = new HashMap<>();
		Paciente paciente = pacienteService.agregarConstantesVitales(idPaciente, constantes);
		ConstantesVitales addConstante = pacienteService.crearConstantes(constantes);
		respuesta.put("idPaciente", paciente.getIdPaciente());
		respuesta.put("idVacuna", addConstante);
		return respuesta;

	}
	
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
		Paciente paciente = pacienteService.findPacienteById(id);
		return ResponseEntity.ok(paciente);
	}
	
	/*@PostMapping("/paciente")
	public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
		Paciente addedPaciente = pacienteService.crearPaciente(paciente);
		return new ResponseEntity<>(addedPaciente, HttpStatus.CREATED);
	}*/
	
	
	
}
