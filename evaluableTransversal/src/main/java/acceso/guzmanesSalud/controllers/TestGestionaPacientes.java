package acceso.guzmanesSalud.controllers;

import acceso.guzmanesSalud.models.ConstantesVitales;
import acceso.guzmanesSalud.models.Paciente;
import acceso.guzmanesSalud.services.PacienteServiceImpl;

public class TestGestionaPacientes {

	public static void main(String[] args) {

		PacienteServiceImpl pacienteServi = new PacienteServiceImpl();
		Paciente p1 = new Paciente();
		Paciente p2 = new Paciente();
		ConstantesVitales c1 = new ConstantesVitales();
		pacienteServi.crearPaciente(p1);
		pacienteServi.crearPaciente(p2);
		
		pacienteServi.findPacienteById(1);
		pacienteServi.agregarConstantesVitales(1, c1);
	}

}
