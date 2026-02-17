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

	@Override
	public Animal addVacunaAAnimal(long id, Vacuna v) {
		// TODO Auto-generated method stub
		
		Animal aninicial = this.findAnimalById(id);
		if (aninicial != null) {
			v.addAnimal(aninicial);
			Vacuna vacunaId = createVacuna(v);
			List<Vacuna> vacunas = aninicial.getVacunas();
			vacunas.add(vacunaId);
			aninicial.setVacunas(vacunas);
		}
		return aninicial;

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
