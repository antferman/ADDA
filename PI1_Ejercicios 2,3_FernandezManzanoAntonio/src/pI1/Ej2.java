package pI1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ej2 {

	public static void ejercicio2Iterativo (String path, LocalDate a, LocalDate b) throws IOException {
		List<String> fechas= Files.lines(Paths.get(path)).collect(Collectors.toList()); //Leo las fechas del fichero
		PrintStream archivo = new PrintStream("ResultadoIterativo.txt"); //Creo el archivo para poder imprimir las fechas en él
		List<String> result = filtraFechasIterativo(a,b,fechas); //filtro las  fechas para que estén entre las dos dadas
		result=ordenaListaIterativo(result); //las ordeno
		int i=0;
		while (i<result.size()) {
			archivo.println(result.get(i));			//las voy imprimiendo en el archivo
			i++;
		}
		archivo.close();
	}
	private static List<String> ordenaListaIterativo(List<String> filtraFechas) {
		//Método de la burbuja
		Integer x=0;
		Integer j=0;
		if(filtraFechas.size()!=0) {
			while(x<filtraFechas.size()-1) {
				while(j<(filtraFechas.size()-x-1)) {
					LocalDate temp0 = convierteFecha(filtraFechas.get(j));
					LocalDate temp1 = convierteFecha(filtraFechas.get(j+1));
					if(!(temp1.isAfter(temp0))) {
						filtraFechas.set(j, temp1.toString());
						filtraFechas.set(j+1, temp0.toString());
					}
				j++;
				}
				j=0;
			x++;
			}
		}else {
			return new ArrayList<>();
		}
	 return filtraFechas;
	}
	
	private static List<String> filtraFechasIterativo(LocalDate a, LocalDate b, List<String> fechas) {
		Integer i=0;
		LocalDate temp = null;
		List<String> fechasOrd= new ArrayList<>();
	//Almaceno en a la fecha menor de las dos

		while (i<fechas.size()) {
			temp = convierteFecha(fechas.get(i));   //convierto la fecha de String a LocalDate
			if (temp.isAfter(a)&&temp.isBefore(b)||temp.isAfter(b)&&temp.isBefore(a)) {
				fechasOrd.add(temp.toString());		//voy añadiendo a la lista las fechas que cumplan la condición
			}
			i++;
		}
		return fechasOrd;
	}
	
	public static LocalDate convierteFecha (String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  //predefino el formato de entrada
		return LocalDate.parse(fecha, formatter);
	}
	
	public static void ejercicio2Java10(String path, LocalDate a, LocalDate b) throws FileNotFoundException{
		List<String> res = new ArrayList<>();
		PrintStream archivo = new PrintStream("ResultadoJava10.txt");
		try {
			res= Files.lines(Paths.get(path)).collect(Collectors.toList()).stream().map(x->convierteFecha(x)).filter(temp->temp.isAfter(a)&&temp.isBefore(b)||temp.isAfter(b)&&temp.isBefore(a)).sorted().map(x->x.toString()).collect(Collectors.toList());
			List<String> s=res; //necesito trabajar con otra lista porque no puedo utilizar el mismo flujo
			IntStream.rangeClosed(0,s.size()-1).boxed().forEach(x->archivo.println(s.get(x))); //imprimo en el archivo
			archivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void ejercicio2Recursivo(String path, LocalDate a, LocalDate b) throws IOException {
		List<String> fechas= Files.lines(Paths.get(path)).collect(Collectors.toList());
		PrintStream archivo = new PrintStream("ResultadoRecursivo.txt");
		int i=0; //índice 1
		int j=0; //índice 2	
		LocalDate temp0= null; //Variable LocalDate temporal para la ordenación por burbuja
		LocalDate temp1=null;  //Variable LocalDate temporal para la ordenación por burbuja
		List<String> res = new ArrayList<>(); //Lista en la que iré almacenando las fechas
		escribeFicheroRecursivo(				//Por último las imprimo tras ordenar y filtrar
			fechasOrdenadasRecursivo(			//Segundo las ordeno
				filtraFechasRecursivo(			//Primero filtro las fechas
						fechas,a,b,res, temp0, i),
				i,j,temp0,temp1,res),archivo, i);
	}
	private static List<String> filtraFechasRecursivo(List<String> fechas,LocalDate a, LocalDate b,List<String>res, LocalDate tmp, int i) {
		if(i<fechas.size()) {
			tmp= convierteFecha(fechas.get(i));
			if(tmp.isAfter(a)&&tmp.isBefore(b)||tmp.isAfter(b)&&tmp.isBefore(a)) {
				res.add(tmp.toString());
			}
			return filtraFechasRecursivo(fechas, a, b, res, tmp, i+1);
		}else {
			return res;
		}
	}
	public static void escribeFicheroRecursivo(List<String> fechasOrdenadasRecursivo,PrintStream archivo, int i) {
		if(i<fechasOrdenadasRecursivo.size()) {
			archivo.println(fechasOrdenadasRecursivo.get(i));
			escribeFicheroRecursivo(fechasOrdenadasRecursivo,archivo,i+1);
		}else {
			archivo.close();
		}
	}
	public static List<String> fechasOrdenadasRecursivo(List<String> fechas, int i,int j,LocalDate temp0, LocalDate temp1,List<String>res) {
		//Ordenación por burbuja en modo recursivo
		if (fechas.size()==0) {
			return new ArrayList<>();
		}else {
			if (i<fechas.size()-1) {
				if(j<fechas.size()-i-1) {
					temp0=convierteFecha(fechas.get(j));
					temp1=convierteFecha(fechas.get(j+1));
					if (!(temp1.isAfter(temp0))){
						res.set(j, temp1.toString());
						res.set(j+1, temp0.toString());						
					}
					return fechasOrdenadasRecursivo(fechas, i, j+1, temp0, temp1, res);
				}else {
					return fechasOrdenadasRecursivo(fechas, i+1, 0, temp0, temp1, res);
				}
			}else {
				return res;
			}
		}
	}
}