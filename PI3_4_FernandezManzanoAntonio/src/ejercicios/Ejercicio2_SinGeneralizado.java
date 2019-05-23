package ejercicios;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Ejercicio2_SinGeneralizado {

	public static void main (String[] args) {
		
		//No necesito el metodo getGoal(), ya que Tiempo es una variable dentro de las soluciones
		SolutionPLI a = AlgoritmoPLI.getSolutionFromFile("ficheros/ficheroEj2.txt");
		System.out.println("Coeficientes de la función objetivo y tiempo mínimo necesario");
		System.out.println("________");
		for (int j = 0; j < a.getNumVar(); j++) {
			System.out.println(a.getName(j)+" = "+a.getSolution()[j]);
		}
	}
}
