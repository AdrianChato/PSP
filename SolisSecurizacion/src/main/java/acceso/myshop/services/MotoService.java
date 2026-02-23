package acceso.myshop.services;

import java.util.List;
import java.util.Optional;

import acceso.myshop.models.Moto;

public interface MotoService {

    Moto guardarMoto(Moto moto);
    List<Moto> listarMotos();
    Optional<Moto> obtenerPorId(Long id);
    // Filtros
    List<Moto> buscarPorMarca(String marca);
    Moto buscarPorMatricula(String matricula);
    List<Moto> motosDeUsuario(Long idUsuario);
    // Modificación
    Moto actualizarCilindrada(Long idMoto, String cilindrada);
    void eliminarMoto(Long id);
}
