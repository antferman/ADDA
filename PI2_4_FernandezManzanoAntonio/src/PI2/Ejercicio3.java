package PI2;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3 {
	
	public static<E extends Comparable <E>> Boolean estaOrdenado(BinaryTree<E>arbol) {
		@SuppressWarnings("unchecked")
		E min =   (E) ""; //Carácter más pequeño en código ascii reconocible por java.
		@SuppressWarnings("unchecked")
		E max =  (E) "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"; 
		//obviando tildes y frases, la palabra mayor que el usuario pueda insertar es la almacenada en max.
		return estaOrdenado(arbol, min, max);
	}
	public static<E extends Comparable <E>> Boolean estaOrdenado(BinaryTree<E> arbol, E min, E max) {
		Boolean res =true;
		switch (arbol.getType()) {
			case Empty:
				res= true;
				break;
			case Leaf:
				if ((arbol.getLabel().toString().compareTo(min.toString())<=0) || arbol.getLabel().toString().compareTo(max.toString())>=0) {
					res= false;
				}else {
					res=true;
				}
				break;
			case Binary:
				if (arbol.getLabel().toString().compareTo(min.toString())<=0 || arbol.getLabel().toString().compareTo(max.toString())>=0) {
					res= false;
					break;
				}
				res= (estaOrdenado(arbol.getLeft(), min, arbol.getLabel())&&estaOrdenado(arbol.getRight(),arbol.getLabel(),max));
		}
		return res;
	}	
	
}