package acceso.veterinaria.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;
import acceso.veterinaria.repositories.AnimalRepository;
import acceso.veterinaria.repositories.VacunaRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClinicaServiceImpl implements ClinicaService {

	@Autowired
	private AnimalRepository animalRepo;
	@Autowired
	private VacunaRepository vacunaRepo;

	@Override
	public List<Vacuna> findAllVacuna() {
		return vacunaRepo.findAll();
	}

	@Override
	public List<Animal> findAllAnimal() {
		return animalRepo.findAll();
	}

	@Override
	public Animal createAnimal(Animal animal) {
		return animalRepo.save(animal);
	}

	/*@Override
	public Animal addVacunaAAnimal(long id, Vacuna v) {
		// TODO Auto-generated method stub
		
		Animal aninicial =this.findAnimalById(id);
		List<Vacuna> vacunas = aninicial.getVacunas();
		if(vacunas.contains(v))
			aninicial.setVacunas(vacunas);
		else {
			Vacuna vacunaId = createVacuna(v);
			vacunas.add(vacunaId);
			aninicial.setVacunas(vacunas);
		}
		vacunaRepo.save(v);
		return aninicial;
	}*/
	
	@Override
	public Animal addVacunaAAnimal(long id, Vacuna v) {

	    Animal animal = this.findAnimalById(id);

	    // Si la vacuna ya existe, la recuperamos
	    Vacuna vacuna;
	    if (v.getIdVacuna() != null) {
	        vacuna = vacunaRepo.findById(v.getIdVacuna())
	                           .orElseThrow(() -> new RuntimeException("Vacuna no encontrada"));
	    } else {
	        vacuna = vacunaRepo.save(v); // Creamos la vacuna nueva
	    }

	    // Evitar duplicados
	    if (!animal.getVacunas().contains(vacuna)) {
	        animal.getVacunas().add(vacuna);
	        vacuna.getAnimales().add(animal);
	    }

	    // Guardar el lado propietario (Vacuna)
	    vacunaRepo.save(vacuna);

	    return animal;
	}
		

	@Override
	public Animal findAnimalById(long id) {
		return animalRepo.findAnimalByIdAnimal(id);
	}

	@Override
	public Vacuna createVacuna(Vacuna vacuna) {
		return vacunaRepo.save(vacuna);
	}

}
