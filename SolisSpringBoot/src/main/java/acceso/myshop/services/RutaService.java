package acceso.myshop.services;

import java.util.List;
import java.util.Optional;

import acceso.myshop.models.Ruta;

public interface RutaService {

    Ruta guardarRuta(Ruta ruta);
    List<Ruta> listarRutas();
    Optional<Ruta> obtenerPorId(Long id);
    Ruta buscarPorNombre(String nombre);
    List<Ruta> filtrarPorDificultad(String dificultad);
    List<Ruta> rutasOficiales();
    Ruta actualizarDescripcion(Long idRuta, String descripcion);
    void eliminarRuta(Long id);
}
