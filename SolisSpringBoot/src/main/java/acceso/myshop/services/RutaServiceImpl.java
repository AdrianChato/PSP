package acceso.myshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.myshop.models.Ruta;
import acceso.myshop.repositories.RutaRepository;
import exceptions.RutaNotFoundException;

@Service
public class RutaServiceImpl implements RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public Ruta guardarRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    @Override
    public List<Ruta> listarRutas() {
        return rutaRepository.findAll();
    }

    @Override
    public Optional<Ruta> obtenerPorId(Long id) {
        return rutaRepository.findById(id);
    }

    @Override
    public Ruta buscarPorNombre(String nombre) {

        Ruta ruta = rutaRepository.findByNombre(nombre);
        if(ruta == null)
            throw new RutaNotFoundException("Ruta no encontrada");
        return ruta;
    }

    @Override
    public List<Ruta> filtrarPorDificultad(String dificultad) {
        return rutaRepository.findByDificultad(dificultad);
    }

    @Override
    public List<Ruta> rutasOficiales() {
        return rutaRepository.findByEsOficialTrue();
    }

    @Override
    public Ruta actualizarDescripcion(Long idRuta, String descripcion) {

        Ruta ruta = rutaRepository.findById(idRuta)
                .orElseThrow(() -> new RutaNotFoundException(idRuta));
        ruta.setDescripcion(descripcion);
        return rutaRepository.save(ruta);
    }

    @Override
    public void eliminarRuta(Long id) {

        Ruta ruta = rutaRepository.findById(id)
                .orElseThrow(() -> new RutaNotFoundException(id));
        rutaRepository.delete(ruta);
    }
}