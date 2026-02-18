package acceso.veterinaria.controllers;

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

import acceso.veterinaria.exceptions.AnimalNotFoundException;
import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;
import acceso.veterinaria.services.ClinicaService;

@Controller
@RequestMapping("/clinica")
public class WebController {

	@Autowired
	private ClinicaService clinicaService;

	@ExceptionHandler(AnimalNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(AnimalNotFoundException pnfe) {
		Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/animal/{id}")
	public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
		Animal animal = clinicaService.findAnimalById(id);
		return ResponseEntity.ok(animal);
	}
	
	@GetMapping("/vacuna/{id}")
	public ResponseEntity<Vacuna> getVacunaById(@PathVariable Long id) {
		Vacuna vacuna = clinicaService.findVacunaById(id);
		return ResponseEntity.ok(vacuna);
	}

	@PostMapping("/animal")
	@ResponseBody
	public String addProduct(@RequestBody Animal animal) {
		Animal addedAnimal = clinicaService.createAnimal(animal);
		String devo = (" el id del animal añadido es " + String.valueOf(addedAnimal.getIdAnimal())); // convertimos Long
		return devo;

	}

	@PostMapping("/vacuna")
	public ResponseEntity<Vacuna> addVacuna(@RequestBody Vacuna vacuna) {
		Vacuna addedVacuna = clinicaService.createVacuna(vacuna);
		return new ResponseEntity<>(addedVacuna, HttpStatus.CREATED);
	}

	// agregar vacuna a un animal
	@PostMapping("/agregarVacuna/{idAnimal}")
	@ResponseBody
	public Map<String, Object> addVacunaAnimal(@PathVariable Long idAnimal, @RequestBody Vacuna vacuna) {
		Map<String, Object> respuesta = new HashMap<>();
		Animal animal = clinicaService.addVacunaAAnimal(idAnimal, vacuna);
		Vacuna vacunaAnimal = clinicaService.findVacunaById(vacuna.getIdVacuna());
		respuesta.put("idAnimal", animal.getIdAnimal());
		respuesta.put("idVacuna", vacunaAnimal.getIdVacuna());
		return respuesta;

	}

}
