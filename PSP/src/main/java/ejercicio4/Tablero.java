package ejercicio4;

public class Tablero {
    private String[][] matriz;
    private int premiosRestantes;

    public Tablero() {
        matriz = new String[3][4]; 
        premiosRestantes = 0;
        inicializarTablero();
    }

    private void inicializarTablero() {
        
        colocarPremio(0, 0, "Crucero");
        colocarPremio(1, 2, "Entradas");
        colocarPremio(2, 0, "Masaje");
        colocarPremio(2, 3, "1000€");
        
        System.out.println("Servidor iniciado...");
        System.out.println("Posiciones con premio: [0,0], [1,2], [2,0], [2,3]");
    }

    private void colocarPremio(int f, int c, String nombre) {
        matriz[f][c] = nombre;
        premiosRestantes++;
    }

    public synchronized String buscarPremio(int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 4) {
            return "COORDENADAS INCORRECTAS";
        }

        if (matriz[fila][columna] != null) {
            String premio = matriz[fila][columna];
            matriz[fila][columna] = null; 
            premiosRestantes--;
            return premio;
        } else {
            return "SIN PREMIO";
        }
    }

    public synchronized boolean quedanPremios() {
        return premiosRestantes > 0;
    }
}