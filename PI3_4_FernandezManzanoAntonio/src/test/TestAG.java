package test;

import java.util.List;
import java.util.Map;
import ejercicios.Ejercicio2AG;
import tiposPI.Procesador;
import tiposPI.Tarea;
import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.common.Strings2;
public class TestAG {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setConstantes();
		ValuesInRangeProblemAG<Integer,Map<Procesador,List<Tarea>>> problema = new Ejercicio2AG("ficheros/Ejercicio2.txt");
		var alg = AlgoritmoAG.<ValuesInRangeChromosome<Integer>>create(ChromosomeType.Range, problema);
		alg.ejecuta();
		ValuesInRangeChromosome<Integer> mejorSolucion= alg.getBestChromosome();
		System.out.println("==============");
		Strings2.toConsole(problema.getSolucion(mejorSolucion).entrySet(), "Reparto de tareas obtenido");
		System.out.println("Tiempo necesario: " + problema.fitnessFunction(mejorSolucion)*-1);
		System.out.println("================");
	}
	private static void setConstantes() {
		//Condiciones de evolucion...		esto es de teoría
		AlgoritmoAG.ELITISM_RATE=0.2;
		AlgoritmoAG.CROSSOVER_RATE=0.85;
		AlgoritmoAG.MUTATION_RATE=0.75;
		AlgoritmoAG.POPULATION_SIZE=100;	
		//Condiciones de parada
		StoppingConditionFactory.NUM_GENERATIONS=10000;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN=1;
		StoppingConditionFactory.FITNESS_MIN=623.;
		StoppingConditionFactory.stoppingConditionType=StoppingConditionType.SolutionsNumber;
	}
}

