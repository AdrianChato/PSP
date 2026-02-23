package acceso.myshop.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.myshop.models.Ruta;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {

    List<Ruta> findByDificultad(String dificultad);
    List<Ruta> findByEsOficialTrue();
    Ruta findByNombre(String nombre);
}
