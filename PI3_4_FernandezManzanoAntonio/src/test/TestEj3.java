package test;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;

import ejercicios.Ejercicio3;
import tiposPI.Ciudad;
import tiposPI.Trayecto;

public class TestEj3 {

	public static void main (String[] args) {
		//			=======================TEST EJERCICIO 3============================
		Graph<Ciudad,Trayecto> g = Ejercicio3.cargarGrafo("./ficheros/Ejercicio3.txt");
		Ejercicio3.apartadoA(g, "Estepa", "Algeciras");
		System.out.println("=============APARTADO B=============");
		Ejercicio3.apartadoB(g);
		g.edgeSet().forEach(a->g.setEdgeWeight(a,a.getCoste()));
		List<Ciudad> a = new ArrayList<>();
		Ciudad b= Ciudad.create("Estepa");
		Ciudad c= Ciudad.create("Cadiz");
		Ciudad d= Ciudad.create("Cordoba");
		a.add(b);
		a.add(c);
		a.add(d);
		System.out.println("================APARTADO C=============");
		Ejercicio3.apartadoC(a,g);
		
//===================================Si quiere comprobarlo con ejemplo.txt=====================================		
//		
//		Graph<Ciudad,Trayecto> g = Ejercicio3.cargarGrafo("./ficheros/ejemplo.txt");
//		Ejercicio3.apartadoA(g, "Lugar0","Lugar9");	
//		System.out.println("=============APARTADO B=============");
//		Ejercicio3.apartadoB(g);
//		g.edgeSet().forEach(a->g.setEdgeWeight(a,a.getCoste()));
//		List<Ciudad> a = new ArrayList<>();
//		Ciudad b= Ciudad.create("Lugar3");
//		Ciudad c= Ciudad.create("Lugar5");
//		Ciudad d= Ciudad.create("Lugar7");
//		a.add(b);
//		a.add(c);
//		a.add(d);
//		System.out.println("================APARTADO C=============");
//		Ejercicio3.apartadoC(a,g);
	}
	
}
