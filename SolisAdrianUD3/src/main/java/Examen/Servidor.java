package Examen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Servidor {

	Map <String, String> datos;
	public static void main(String[] args) {
		
		int puerto = 5555;
		int idCliente = 0;
		
		try (ServerSocket servidor = new ServerSocket(puerto)) {

            System.out.println("Servidor escuchando en el puerto " + puerto);

			while (true) {
				Socket socketCliente = servidor.accept();
				idCliente++;
				new ManejadorHiloServidor(socketCliente, idCliente).start();
			}
		} catch (IOException e) {
			System.err.println("Error en el servidor: " + e.getMessage());
		}
	}

	public Servidor() {
		super();
		this.datos = new HashMap<>();
		colocarDatos();
	}

	public String generaVoto() {
		Candidato[] valores = Candidato.values();
		Random r = new Random();
		int pos = r.nextInt(valores.length);
		Candidato c = valores[pos];
		return c.name();
	}
	public void colocarDatos() {
		int f = 0;
        String clave = "DNI: 23452101+" + f++ +":::";
        datos.put(clave, generaVoto());
        System.out.println(datos);
		
    }

	@Override
	public String toString() {
		return "Servidor [datos=" + datos + "]";
	}
	
	
	

}
