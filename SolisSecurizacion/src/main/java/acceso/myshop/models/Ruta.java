package acceso.myshop.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rutas")
public class Ruta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRuta;
	@Column
	private String nombre;
	@Column
	private long distancia_km;
	@Column
	private String dificultad;
	@Column
	private String tipo_terreno;
	@Column
	private String descripcion;
	@Column
	private boolean esOficial; 
	
	@ManyToMany(mappedBy = "rutas")
	private List<Moto> motos;
}
