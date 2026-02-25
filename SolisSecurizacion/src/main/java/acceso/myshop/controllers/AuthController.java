package acceso.myshop.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acceso.myshop.models.Usuario;
import acceso.myshop.services.UsuarioService;
import acceso.myshop.util.JWTUtility;

@RestController
@RequestMapping("/SolisSecurizacion/login")
public class AuthController {
	private static final Logger logger = LogManager.getLogger(AuthController.class);
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
		     UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(usuario.getNombre(), usuario.getPassword_hash());		
		Authentication authentication = authenticationManager.authenticate(token);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		return jwtUtils.generateToken(userDetails.getUsername());
	}
	
	@PostMapping("/nuevoUsuario")
	   public String registerUser(@RequestBody Usuario user) {
			logger.debug("Entro en alta");
	       if (usuarioService.existsByNombre(user.getNombre())) {
	           return "Error: Username is already taken!";
	       }
	       // Create new user's account
	       Usuario newUser = new Usuario(null, user.getNombre(), encoder.encode(user.getPassword_hash()));
	       usuarioService.saveUsuario(newUser);
	       return "User registered successfully!";
	   }
	}