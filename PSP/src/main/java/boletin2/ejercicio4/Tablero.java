package boletin2.ejercicio4;

public class Tablero {

    // Matriz que representa el tablero de juego (3 filas y 4 columnas)
    // En cada posición puede haber un premio o nada (null)
    private String[][] tablero;

    // Número de premios que quedan disponibles
    private int premios;

    // Constructor: se ejecuta cuando se crea el tablero
    public Tablero() {

        // Creamos el tablero de 3x4
        tablero = new String[3][4];

        // Colocamos los premios en posiciones concretas
        tablero[0][0] = "Crucero";
        tablero[1][2] = "Entradas";
        tablero[2][0] = "Masaje";
        tablero[2][3] = "1000€";

        // Al empezar hay 4 premios
        premios = 4;
    }

    // Este método sirve para saber si aún quedan premios
    // synchronized significa que solo un cliente puede preguntar a la vez
    public synchronized boolean quedanPremios() {
        return premios > 0;
    }

    // Este método comprueba si en una posición hay premio
    // Si hay premio, lo devuelve y lo borra del tablero
    public synchronized String comprobar(int fila, int columna) {

        // Si en esa posición hay algo (no es null)
        if (tablero[fila][columna] != null) {

            // Guardamos el premio
            String premio = tablero[fila][columna];

            // Quitamos el premio del tablero para que nadie más lo gane
            tablero[fila][columna] = null;

            // Reducimos el número de premios
            premios--;

            // Devolvemos el premio al cliente
            return premio;
        }

        // Si no había premio, devolvemos null
        return null;
    }
}
