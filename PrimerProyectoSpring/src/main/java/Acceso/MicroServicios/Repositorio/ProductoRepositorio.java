package Acceso.MicroServicios.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Acceso.MicroServicios.Modelo.Product;

@Repository
public interface ProductoRepositorio extends JpaRepository<Product, Long>{

	

}
