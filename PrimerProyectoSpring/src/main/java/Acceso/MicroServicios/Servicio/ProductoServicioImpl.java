package Acceso.MicroServicios.Servicio;

import org.springframework.beans.factory.annotation.Autowired;

import Acceso.MicroServicios.Repositorio.ProductoRepositorio;

public class ProductoServicioImpl implements IProductoServicio{

	@Autowired
	private ProductoRepositorio productoRepositorio;
}
