package test;

import java.util.List;

import ejercicios.Ejercicio2_Generalizado;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class TestEj2Generalizado {
	public static void main(String[] args) {
		List<String> datos = Ejercicio2_Generalizado.cargaDatos("./ficheros/Ejercicio2.txt");
		SolutionPLI alg = AlgoritmoPLI.getSolution(Ejercicio2_Generalizado.defineProblema(datos));
		System.out.println("Coeficientes de la Función Objetivo y tiempo minimo necesario:");
		for (int j = 0; j < alg.getNumVar(); j++) {
			System.out.println(alg.getName(j)+" = "+alg.getSolution()[j]);
		}
	}
}
