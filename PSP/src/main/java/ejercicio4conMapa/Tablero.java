package ejercicio4conMapa;

import java.util.HashMap;
import java.util.Map;

public class Tablero {
    // Usamos un Map donde la clave es "fila,columna" y el valor es el premio
    private Map<String, String> premios;
    private final int FILAS = 3;
    private final int COLUMNAS = 4;

    public Tablero() {
        premios = new HashMap<>();
        inicializarTablero();
    }

    private void inicializarTablero() {
        // Metemos datos en el Map
        colocarPremio(0, 0, "Crucero");
        colocarPremio(1, 2, "Entradas");
        colocarPremio(2, 0, "Masaje");
        colocarPremio(2, 3, "1000€");
        
        System.out.println("Servidor iniciado con Map...");
        System.out.println("Posiciones con premio: [0,0], [1,2], [2,0], [2,3]");
    }

    private void colocarPremio(int f, int c, String nombre) {
        String clave = f + "," + c;
        premios.put(clave, nombre);
    }

    public synchronized String buscarPremio(int fila, int columna) {
        // Validar límites manualmente
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            return "COORDENADAS INCORRECTAS";
        }

        String clave = fila + "," + columna;

        // Recuperamos datos del Map
        if (premios.containsKey(clave)) {
            String premio = premios.remove(clave); // Recupera y elimina al mismo tiempo
            return premio;
        } else {
            return "SIN PREMIO";
        }
    }

    public synchronized boolean quedanPremios() {
        // Ahora simplemente comprobamos si el Map está vacío
        return !premios.isEmpty();
    }
}