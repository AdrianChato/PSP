package acceso.myshop.models;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	@Column(unique=true)
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String email;
	@Column
	private String telefono;
	@Column
	private String password_hash;
	@Column
	private String rol;
	@Column
	private boolean verificado;
	@Column
	private LocalDate fecha_registro;
	
	@OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
	@JsonIgnore //Para evitar bucle que me da al buscar
	private List<Moto> motos;

	public Usuario(long idUsuario, String nombre, String password_hash) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.password_hash = password_hash;
	}

	public Usuario(Object object, String nombre2, String encode) {
		// TODO Auto-generated constructor stub
	}
	
	

}
