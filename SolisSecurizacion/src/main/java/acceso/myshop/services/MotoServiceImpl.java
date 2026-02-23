package acceso.myshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acceso.myshop.models.Moto;
import acceso.myshop.repositories.MotoRepository;
import exceptions.MotoNotFoundException;

@Service
public class MotoServiceImpl implements MotoService {

    @Autowired
    private MotoRepository motoRepository;

    @Override
    public Moto guardarMoto(Moto moto) {
        return motoRepository.save(moto);
    }

    @Override
    public List<Moto> listarMotos() {
        return motoRepository.findAll();
    }

    @Override
    public Optional<Moto> obtenerPorId(Long id) {
        return motoRepository.findById(id);
    }

    @Override
    public List<Moto> buscarPorMarca(String marca) {
        return motoRepository.findByMarca(marca);
    }

    @Override
    public Moto buscarPorMatricula(String matricula) {

        Moto moto = motoRepository.findByMatricula(matricula);
        if(moto == null)
            throw new MotoNotFoundException("Moto no encontrada");
        return moto;
    }

    @Override
    public List<Moto> motosDeUsuario(Long idUsuario) {
        return motoRepository.findByPropietarioIdUsuario(idUsuario);
    }

    @Override
    public Moto actualizarCilindrada(Long idMoto, String cilindrada) {

        Moto moto = motoRepository.findById(idMoto)
                .orElseThrow(() -> new MotoNotFoundException(idMoto));
        moto.setCilindrada(cilindrada);
        return motoRepository.save(moto);
    }

    @Override
    public void eliminarMoto(Long id) {

        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new MotoNotFoundException(id));
        motoRepository.delete(moto);
    }
}