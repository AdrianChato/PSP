package Unidad1.Boletin1;

import java.io.IOException;

public class LanzadorPython {
	public static void main(String[] args) {
		try {

			ProcessBuilder pb = new ProcessBuilder(

					"python", "src\\main\\resources\\fichery.py"

			);

			pb.redirectErrorStream(true); 

			pb.inheritIO(); 

			Process process = pb.start();

			process.waitFor();

		} catch (IOException | InterruptedException e) {

			e.printStackTrace();

		}

	}

}
