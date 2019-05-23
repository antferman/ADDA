package pI1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ej3 {
//	Obtener una List<Integer> a partir de un fichero de texto que contiene en cada línea una lista de números enteros separados por comas. 
	public static List<Integer> ejercicio3Iterativo (String path) throws IOException{
		List<String> lineas= Files.lines(Paths.get(path)).collect(Collectors.toList()); //Leo todo el fichero
		List<Integer> res = new ArrayList<>();
		int i=0;
		int j=0;
		while(i<lineas.size()) {
			String[] temp= lineas.get(i).trim().split(","); //Quito espacios con trim() y meto en la array temp cada linea de numeros que he leido haciendo split por ","
			while (j<temp.length) {
				res.add(Integer.parseInt(temp[j])); //Cojo cada numero, lo cnvierto a Integer y lo añado a la variable res
				j++;
			}
			j=0;
			i++;
		}
		return res;
	}

	public static List<Integer> ejercicio3Java10(String path) throws IOException{	
		List<String> lineas= Files.lines(Paths.get(path)).collect(Collectors.toList());
		return lineas.stream().map(z->z.trim().split(",")).flatMap(x->Arrays.stream(x)).mapToInt(x->Integer.parseInt(x)).boxed().collect(Collectors.toList());

	}

	public static List<Integer> ejercicio3Recursivo (String path) throws IOException{
		List<String> lineas= Files.lines(Paths.get(path)).collect(Collectors.toList());
		int i=0; //índice 1
		int j=0; //índice 2
		List<Integer> res= new ArrayList<>(); //lista res auxialiar donde añadiré los resultados
		return Ej3RecursivoFinal(lineas,i,j,res);
	}
	private static List<Integer> Ej3RecursivoFinal(List<String> lineas, int i, int j, List<Integer> res) {
		if(lineas.size()==0) {
			return res;
		}else {
			if (i<lineas.size()) {
				String[] temp= lineas.get(i).trim().split(","); //hago el split de "," y elimino espacios
				anadeRecursivo(temp,j,res);   
				return Ej3RecursivoFinal(lineas,i+1,j,res);
			}
		}
		return res;
	}

	public static List<Integer> anadeRecursivo(String[] temp, int j, List<Integer> res) {
		if(j<temp.length) {
			res.add(Integer.parseInt(temp[j]));
			return anadeRecursivo(temp,j+1,res);
		}else {
			return res;
		}
	}
}
