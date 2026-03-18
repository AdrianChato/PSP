package acceso.myshop.models;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario; // Cambiado a Long para permitir nulos en el alta

    @Column(unique=true)
    private String nombre;

    private String apellidos;
    private String email;
    private String telefono;
    
    @Column(name = "password_hash")
    private String password_hash;

    private String rol;
    private boolean verificado;
    private LocalDate fecha_registro;
    
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    @JsonIgnore 
    private List<Moto> motos;

    // Constructor rápido para el login/registro
    public Usuario(String nombre, String password_hash) {
        this.nombre = nombre;
        this.password_hash = password_hash;
    }
}