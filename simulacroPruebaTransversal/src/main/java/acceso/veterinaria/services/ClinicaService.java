package acceso.veterinaria.services;

import java.util.List;
import java.util.Set;

import acceso.veterinaria.models.Animal;
import acceso.veterinaria.models.Vacuna;

public interface ClinicaService {

	List<Vacuna> findAllVacuna();
	List<Animal> findAllAnimal();
    Animal findAnimalById(long id);
    public Animal createAnimal (Animal animal);
    public Vacuna createVacuna (Vacuna vacuna);
    public Animal addVacunaAAnimal (long id, Vacuna v);
}
