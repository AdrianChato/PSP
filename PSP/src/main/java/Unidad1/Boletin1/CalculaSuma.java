package Unidad1.Boletin1;

public class CalculaSuma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculaSuma cs = new CalculaSuma();
		cs.realizasuma(args[0], args[1]);
		System.out.println(cs.realizasuma(args[0], args[1]));

	}
	
	public int realizasuma(String parimpar, String num2) {
		  int numerosumado = 0;
	      int limite = Integer.parseInt(num2);
	      	if(parimpar.equalsIgnoreCase("par")) {
	      		for(int i = 0; i <= limite; i++) {
	      			if(i % 2 == 0) {
	      				numerosumado += i;
              }
          }
      } else if(parimpar.equalsIgnoreCase("impar")) {
          for(int i = 0; i <= limite; i++) {
              if(i % 2 != 0) {
                  numerosumado += i;
              }
          }
      } else {
          System.out.println("El primer argumento debe ser 'par' o 'impar'.");
      }
      return numerosumado;

  }
	
}
