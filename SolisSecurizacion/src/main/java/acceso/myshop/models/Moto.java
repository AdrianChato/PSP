package acceso.myshop.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "motos")
public class Moto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMoto;
	@Column
	private String marca;
	@Column
	private String modelo;
	@Column
	private String matricula;
	@Column
	private String cilindrada;
	@Column
	private String itv_fecha;
	@Column
	private String qr_codigo;
	
	@ManyToOne
	@JoinColumn(name = "id_propietario")
	private Usuario propietario;

	@ManyToMany
	@JoinTable(
	    name = "moto_ruta",
	    joinColumns = @JoinColumn(name = "id_moto"),
	    inverseJoinColumns = @JoinColumn(name = "id_ruta")
	)
	private List<Ruta> rutas;
}
