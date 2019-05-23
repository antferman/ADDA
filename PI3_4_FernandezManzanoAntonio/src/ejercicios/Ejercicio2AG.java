package ejercicios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tiposPI.Procesador;
import tiposPI.Tarea;
import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;

import us.lsi.common.Streams2;


public class Ejercicio2AG implements ValuesInRangeProblemAG<Integer, Map<Procesador,List<Tarea>>> {
	private static List<Procesador> procesadores;
	private static List<Tarea> tareas;
	
	public Ejercicio2AG(String fichero) {
	//Leo el fichero y guardo en las variables dichos datos
		procesadores = getProcesadores(cargaDatos(fichero));
		tareas= getTareas(cargaDatos(fichero));
	}

	public Integer getVariableNumber() {
		return tareas.size();
	}

	public Integer getMax(Integer i) {
		return procesadores.size();
	}

	public Integer getMin(Integer i) {
		return 0;
	}

	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {
		Map<Procesador,List<Tarea>> m = getSolucion(cr);
		double tiempo=0.;
		double temp=0.;
		for (int i=0; i<m.size(); i++) {
			Procesador p =procesadores.get(i);
			temp=m.get(p).stream().mapToInt(Tarea::getDuracion).sum();
			tiempo = (tiempo>temp)?tiempo:temp;
		}
		return -tiempo;
	}

	public Map<Procesador, List<Tarea>> getSolucion(ValuesInRangeChromosome<Integer> cr) {
		List<Integer> solucion = cr.decode();
		//la solucion estara compuesta por el número del procesador que realice cada tarea i. 
		Map<Procesador,List<Tarea>> res= new HashMap<>();
		for (int i=0; i<procesadores.size();i++) {
			Procesador key= procesadores.get(i);
			List<Tarea> ls = new ArrayList<>();
			for (int j=0; j<solucion.size();j++) {
				if (solucion.get(j)==i) {
					ls.add(tareas.get(j));
				}
			}
				res.put(key, ls);
		}
		return res;
	}

	private static List<Procesador> getProcesadores(List<String> datos) {
		String[] array = datos.get(0).trim().split("=");
		array= array[1].trim().split(",");
		List<Procesador> ls = new ArrayList<>();
		for (int i=0; i<array.length; i++) {
			ls.add(Procesador.create(array[i]));
		}
		return ls;
	}
	private static List<Tarea> getTareas(List<String> datos){
		String[] array = datos.get(1).trim().split("=");
		array= array[1].trim().split(",");
		List<Tarea> ls = new ArrayList<>();
		for (int i=0; i<array.length; i++) {
			ls.add(Tarea.create(array[i]));
		}
		return ls;
		
	}
	private static List<String> cargaDatos(String fichero) {
		return Streams2.fromFile(fichero).collect(Collectors.toList());
	}
}
