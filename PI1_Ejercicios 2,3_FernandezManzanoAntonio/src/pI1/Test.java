package pI1;

import java.io.IOException;
import java.time.LocalDate;
public class Test {

	public static void main(String[] args) throws IOException {
		LocalDate a = LocalDate.now();
		LocalDate b = LocalDate.of(1998, 2, 1);
		Ej2.ejercicio2Iterativo("Ej2-prueba",a,b);
		Ej2.ejercicio2Java10("Ej2-prueba",a,b);
		Ej2.ejercicio2Recursivo("Ej2-prueba",a,b);
		System.out.println("Ejercicio 3 Iterativo: \n" + Ej3.ejercicio3Iterativo("Ej3-prueba")+ "\n");	
		System.out.println("Ejercicio 3 Funcional: \n" + Ej3.ejercicio3Java10("Ej3-prueba")+ "\n");	
		System.out.println("Ejercicio 3 Recursivo: \n" + Ej3.ejercicio3Recursivo("Ej3-prueba"));
		
	}

}
