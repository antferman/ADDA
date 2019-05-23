package problemas;

import java.util.Arrays;

import us.lsi.bt.AlgoritmoBT;
import us.lsi.pd.AlgoritmoPD;

public class TestEj2 {

	public static void main(String[] args) {
		System.out.println("======================EJERCICIO 2 BACKTRACKING=====================\n");
		System.out.println("Dada la lista de n�meros: "+ Ejercicio2BT.numeros + " y  un entero n = " + Ejercicio2BT.n +" una soluci�n maximizando el n�mero de pares es:" );
	
		AlgoritmoBT.isRandomize=false;
		Ejercicio2BackTracking estadoInicial= Ejercicio2BackTracking.create();
		AlgoritmoBT<SolucionEjercicio2BackTracking,Integer,Ejercicio2BackTracking> alg = AlgoritmoBT.create(estadoInicial);
		alg.ejecuta();
	
		System.out.println(alg.getSolucion());
		
	//=================================================PDR============================================================
		System.out.println("\n\n======================EJERCICIO 2 PDR=====================\n");
		Ejercicio2PDR p = Ejercicio2PDR.create(Arrays.asList(1,3,1,1,2,5,8,10,6,11));
		System.out.println("Dada la lista de n�meros: "+ Ejercicio2PDR.numeros + " y  un entero n = " + Ejercicio2PDR.n +" una soluci�n maximizando el n�mero de pares es:" );
		AlgoritmoPD.isRandomize = false;	
		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		String s = (a.getSolucion()==null) ? "No hay soluci�n":a.getSolucion().toString();
		System.out.println(s);
	}
}
