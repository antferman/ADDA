package PI2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import us.lsi.tiposrecursivos.BinaryTree;

public class test {

	public static void main(String[] args) {
		//Test para ejercicio 2
		List<Integer> a = new ArrayList<>();
		a.add(22);
		a.add(11);
		a.add(22);
		a.add(3);
		a.add(2);
		a.add(0);
		a.add(33);
//		System.out.println("Ejercicio2 \n\nLa lista insertada es: \n" + a +"\n\n" + "La lista ordenada respecto al orden dado, resulta: ");
		Ejercicio2.mergeSort(a, Comparator.reverseOrder());
		System.out.println(a +"\n");
		
//		List<String> b = new ArrayList<>();
//		b.add("s");
//		b.add("a");
//		b.add("r");
//		b.add("w");
//		b.add("f");
//		b.add("s");
//		b.add("c");
//		System.out.println("\n\nLa lista insertada es: \n" + b +"\n\n" + "La lista ordenada respecto al orden dado, resulta: ");
//		Ejercicio2.mergeSort(b, Comparator.reverseOrder());
//		System.out.println(b +"\n");
//		
//		List<String> d = new ArrayList<>();
//		System.out.println("\n\nLa lista insertada es: \n" + d +"\n\n" + "La lista ordenada respecto al orden dado, resulta: ");
//		Ejercicio2.mergeSort(d, Comparator.reverseOrder());
//		System.out.println(d +"\n\n\n\nEjercicio 3\n\n");
//		
//		//Test para ejercicio 3
//		var arboles2 = binaryTrees();
//		arboles2.forEach(c-> System.out.println("El árbol :->       " + c +
//							"      -> está ordenado = "+ Ejercicio3.estaOrdenado((c))));
//		var arboles3 = binaryTrees2();
//		arboles3.forEach(c-> System.out.println("El árbol :->       " + c +
//				"      -> está ordenado = "+ Ejercicio3.estaOrdenado((c))));

		
	}
	private static List<BinaryTree<Integer>>binaryTrees(){
		var res = new ArrayList<BinaryTree<Integer>>();
		res.add(BinaryTree.empty());
		res.add(BinaryTree.leaf(2));
		res.add(BinaryTree.leaf(3));
		res.add(BinaryTree.leaf(4));
		res.add(BinaryTree.binary(42,res.get(0), res.get(1)));
		res.add(BinaryTree.binary((5),BinaryTree.binary(3,BinaryTree.leaf(2),BinaryTree.leaf(4)),BinaryTree.leaf(6)));
		res.add(BinaryTree.binary(1,res.get(0), res.get(1)));
		return res;
	}
	private static List<BinaryTree<String>>binaryTrees2(){
		var res = new ArrayList<BinaryTree<String>>();
		res.add(BinaryTree.empty());
		res.add(BinaryTree.leaf("a"));
		res.add(BinaryTree.leaf("b"));
		res.add(BinaryTree.leaf("c"));
		res.add(BinaryTree.binary("a",res.get(0), res.get(1)));
		res.add(BinaryTree.binary(("e"),BinaryTree.binary("c",BinaryTree.leaf("b"),BinaryTree.leaf("d")),BinaryTree.leaf("")));
		res.add(BinaryTree.binary(("la"),BinaryTree.binary("gallina",BinaryTree.leaf("blanca"),BinaryTree.leaf("kakarea")),BinaryTree.leaf("tontamente")));
		res.add(BinaryTree.binary(" ",res.get(0), res.get(1)));
		return res;
	}

}
