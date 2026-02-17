package acceso.myshop.services;

import java.util.List;
import java.util.Optional;

import acceso.myshop.models.Usuario;

public interface UsuarioService {

    // Alta
    Usuario guardarUsuario(Usuario usuario);
    // Listado
    List<Usuario> listarUsuarios();
    // Buscar por ID
    Optional<Usuario> obtenerPorId(Long id);
    // Buscar por email
    Optional<Usuario> buscarPorEmail(String email);
    // Modificar rol 
    Usuario actualizarRol(Long id, String nuevoRol);
    // Borrar
    void eliminarUsuario(Long id);
}
