package ejercicios;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import tiposPI.Tarea;
import us.lsi.common.Streams2;

public class Ejercicio2_Generalizado {
	
	public static String defineProblema(List<String> datos) {
		String res = "";
		List<Tarea>tareas= getTareas(datos);
		Integer procesadores = getProcesadores(datos);
		res = res + funcionObjetivo(tareas,procesadores);
		res= res + restriccionTareaUnica(tareas,procesadores);
		res = res + variablesBinarias(tareas,procesadores);
		return res;
	}	
	private static String variablesBinarias(List<Tarea> ls,Integer n) {
		//bin x00,x01,x02,x03,x04,x10,x11,x12,x13,x14
		//Declaro las variables como binarias
		String r= "\nbin ";
		Boolean first = true;
		for (int i = 0; i < n; i++) {	
			for (int j = 0; j < ls.size(); j++) {
				if (first) first = false; else r = r + ",";
				r = r + String.format("x%d%d", i, j);
			}
		}	
		r= r + ";";
		return r;
	}
	private static String restriccionTareaUnica(List<Tarea> ls,Integer n) {
		//	x00+x10 = 1;
		//	x01+x11 = 1;
		//	x02+x12 = 1;
		//	x03+x13 = 1;
		//	x04+x14 = 1;
		//  Cada tarea solo se puede realizar en un solo procesador
		String r="";
		boolean first = true;
		for (int i = 0; i < ls.size(); i++) {
			first =true;
			for (int j = 0; j < n; j++) {
				if (first) first = false; else r = r + "+";
				r = r + String.format("x%d%d", j, i);
			}
			r = r +" = 1;\n";
		}
		return r;
	}
	private static String funcionObjetivo(List<Tarea> ls,Integer n) {
		//  min: Tiempo;
		//  5*x00+4*x01+6*x02+3*x03+2*x04 <=Tiempo;
		//  5*x10+4*x11+6*x12+3*x13+2*x14 <=Tiempo;
		//  Minimizo el tiempo de cada procesador
		String r = "min: Tiempo;\n\n";
		Boolean first = true;
		for(int i =0;i<n;i++){
			first=true;
			for (int j = 0; j < ls.size(); j++) {
				if (first) first = false; else r = r + "+";
				r = r + String.format("%d*x%d%d",ls.get(j).getDuracion(), i, j);
			}
			r = r +" <=Tiempo;\n";
		}
		r= r + "\n";
		return r;
	}
	public static List<String> cargaDatos(String fichero) {
		return Streams2.fromFile(fichero).collect(Collectors.toList());
	}
	private static Integer getProcesadores(List<String> datos) {
		String[] array = datos.get(0).trim().split("=");
		array= array[1].trim().split(",");
		Integer procesadores = array.length;
		return procesadores;
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
}
