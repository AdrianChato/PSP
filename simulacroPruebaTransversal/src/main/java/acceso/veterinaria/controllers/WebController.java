package acceso.veterinaria.controllers;

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

	@PutMapping("/animal/{id}")
	public ResponseEntity<Animal> updateProduct(@PathVariable Long id, @RequestBody Vacuna vacuna) {
		Animal addedVacuna = clinicaService.addVacunaAAnimal(id, vacuna);
		return new ResponseEntity<>(addedVacuna, HttpStatus.CREATED);
	}

}
