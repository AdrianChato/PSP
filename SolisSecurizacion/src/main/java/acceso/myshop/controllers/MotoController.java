package acceso.myshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import acceso.myshop.models.Moto;
import acceso.myshop.models.Ruta;
import acceso.myshop.models.Usuario;
import acceso.myshop.services.MotoService;
import acceso.myshop.services.RutaService;
import acceso.myshop.services.UsuarioService;


@Controller
@RequestMapping("/SolisSpringBoot")
public class MotoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MotoService motoService;

    @Autowired
    private RutaService rutaService;

    // Index de la página de inicio

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Parte de usuarios

    @GetMapping("/usuarios")
    public String verUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "usuarios";
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Usuario added = usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }

    @PutMapping("/usuario/{id}/rol")
    public ResponseEntity<Usuario> cambiarRol(@PathVariable Long id, @RequestBody String nuevoRol) {
        Usuario actualizado = usuarioService.actualizarRol(id, nuevoRol);
        return ResponseEntity.ok(actualizado);
    }

    // Parte de motos

    @GetMapping("/motos")
    public String verMotos(Model model) {
        model.addAttribute("motos", motoService.listarMotos());
        return "motos";
    }

    @PostMapping("/moto")
    public ResponseEntity<Moto> addMoto(@RequestBody Moto moto) {
        Moto added = motoService.guardarMoto(moto);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }

    @GetMapping("/motos/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable Long id) {
        Moto moto = motoService.obtenerPorId(id).orElseThrow();
        return ResponseEntity.ok(moto);
    }

    // Parte de rutas

    @GetMapping("/rutas")
    public String verRutas(Model model) {
        model.addAttribute("rutas", rutaService.listarRutas());
        return "rutas";
    }

    @PostMapping("/ruta")
    public ResponseEntity<Ruta> addRuta(@RequestBody Ruta ruta) {
        Ruta added = rutaService.guardarRuta(ruta);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }

    @GetMapping("/rutas/oficiales")
    public ResponseEntity<List<Ruta>> rutasOficiales() {
        return ResponseEntity.ok(rutaService.rutasOficiales());
    }
}
