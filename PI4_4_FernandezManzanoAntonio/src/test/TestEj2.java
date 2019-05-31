package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import problemas.Ejercicio2BT;
import problemas.Ejercicio2BackTracking;
import problemas.Ejercicio2GV;
import problemas.Ejercicio2PDR;
import problemas.SolucionEjercicio2BackTracking;
import problemas.VerticeGV;
import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.astar.AStarSimpleVirtualGraph;
import us.lsi.bt.AlgoritmoBT;
import us.lsi.pd.AlgoritmoPD;

public class TestEj2 {

	public static void main(String[] args) {
		System.out.println("======================EJERCICIO 2 BACKTRACKING=====================\n");
		System.out.println("Dada la lista de números: "+ Ejercicio2BT.numeros + " y  un entero n = " + Ejercicio2BT.n +" una solución maximizando el número de pares es:" );
		AlgoritmoBT.isRandomize=false;
		Ejercicio2BackTracking estadoInicial= Ejercicio2BackTracking.create();
		AlgoritmoBT<SolucionEjercicio2BackTracking,Integer,Ejercicio2BackTracking> alg = AlgoritmoBT.create(estadoInicial);
		alg.ejecuta();
		System.out.println(alg.getSolucion());
		
	//=================================================PDR============================================================
		System.out.println("\n\n======================EJERCICIO 2 PDR=====================\n");
		Ejercicio2PDR p = Ejercicio2PDR.create(Arrays.asList(1,3,1,1,2,5,8,10,6,11));
		System.out.println("Dada la lista de números: "+ Ejercicio2PDR.numeros + " y  un entero n = " + Ejercicio2PDR.n +" una solución maximizando el número de pares es:" );
		AlgoritmoPD.isRandomize = false;	
		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		String s = (a.getSolucion()==null) ? "No hay solución":a.getSolucion().toString();
		System.out.println(s);
	
	
	
		//=================================================GV============================================================
		System.out.println("\n\n======================EJERCICIO 2 GV=====================\n");
		System.out.println("Dada la lista de números: "+ VerticeGV.numeros + " y  un entero n = " + VerticeGV.n +" una solución maximizando el número de pares es:" );	
		VerticeGV e = VerticeGV.of();
		AStarGraph<VerticeGV,Ejercicio2GV>  graph = AStarSimpleVirtualGraph.of(r ->r.getEdgeWeight());
		Predicate<VerticeGV> goal = (VerticeGV v) -> v.index == VerticeGV.numeros.size()&& v.suma == VerticeGV.n;
		var alg1 = AStarAlgorithm.of(graph,e,goal,(v,c)->0.);		
		List<Integer> s1 = alg1.getPathVertexList().get(alg1.getPathVertexList().size()-1).getSolucion();
		System.out.println(s1);
		

	}
}
