package acceso.myshop.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import acceso.myshop.models.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

    List<Moto> findByMarca(String marca);
    Moto findByMatricula(String matricula);
    List<Moto> findByPropietarioIdUsuario(Long idUsuario);
}
