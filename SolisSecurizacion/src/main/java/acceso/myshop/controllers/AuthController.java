package acceso.myshop.controllers;

import acceso.myshop.models.Usuario;
import acceso.myshop.services.UsuarioService;
import acceso.myshop.util.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/auth") // Ruta base simple
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JWTUtility jwtUtils; 

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getNombre(), usuario.getPassword_hash()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtils.generateToken(userDetails.getUsername());
    }
    
    @PostMapping("/registro") // Ruta para dar de alta
    public String registerUser(@RequestBody Usuario user) {
        if (usuarioService.existsByNombre(user.getNombre())) {
            return "Error: El usuario ya existe";
        }
        
        Usuario newUser = new Usuario();
        newUser.setNombre(user.getNombre());
        newUser.setPassword_hash(encoder.encode(user.getPassword_hash())); 
        newUser.setRol("USER");
        
        usuarioService.guardarUsuario(newUser); // Usamos el método de tu Service
        return "Usuario registrado con éxito";
    }
}