package PI2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Ejercicio2 {

	public static <E> List<E> mergeSort(List<E> lista, Comparator<? super E> ord){
		List<E> ls = new ArrayList<>(lista);
		List<E> ls1 = new ArrayList<>();
		int i=0;
		int j = lista.size();
		ls1=mergeSortRecursivo(lista,i,j,ord,ls);	
		return ls1;
	}
	private static <E> List<E> mergeSortRecursivo(List<E> lista, int i, int j, Comparator<? super E> ord, List<E> ls){
		if(j-i > 1){
			int k = (j+i)/2;
			mergeSortRecursivo(lista,i,k,ord,ls); //parte izquierda de la lista
			mergeSortRecursivo(lista,k,j,ord,ls); //parte derecha de la lista
			compara(lista,i,k,lista,k,j,ls,i,j,ord); 
			meteLista(lista,i,j,ls,i);
		}
		return lista;
	}
	private static <E> void compara(List<E> lista1, int indiceIzquierdo, int medioIzq, List<E> lista2, int medioDerecha, int indiceDerecha, List<E> lista3, int indiceInicio, int indiceFin, Comparator<? super E> orden){
		if(indiceInicio<indiceFin){
			if(!(indiceIzquierdo<medioIzq && medioDerecha<indiceDerecha)){
				if(!(medioDerecha==indiceDerecha)){
					lista3.set(indiceInicio, lista2.get(medioDerecha));
					compara(lista1,indiceIzquierdo, medioIzq, lista2, medioDerecha+1, indiceDerecha, lista3, indiceInicio +1, indiceFin, orden);
				}else{
					lista3.set(indiceInicio, lista1.get(indiceIzquierdo));			
					compara(lista1,indiceIzquierdo+1, medioIzq, lista2, medioDerecha, indiceDerecha, lista3, indiceInicio +1, indiceFin, orden);
				}
			}else
				if(!(orden.compare(lista1.get(indiceIzquierdo), lista2.get(medioDerecha))<=0)){
					lista3.set(indiceInicio, lista2.get(medioDerecha));
					compara(lista1,indiceIzquierdo, medioIzq, lista2, medioDerecha+1, indiceDerecha, lista3, indiceInicio +1, indiceFin, orden);
				}else{
					lista3.set(indiceInicio, lista1.get(indiceIzquierdo));
					compara(lista1,indiceIzquierdo+1, medioIzq, lista2, medioDerecha, indiceDerecha, lista3, indiceInicio +1, indiceFin, orden);
				}
			}
		}
		//Si no entra en el if, es porque no se cumple el caso base.
	private static <E> void meteLista(List<E> lista, int i, int j, List<E> ls, int z){
		if (z<j) {
			lista.set(z, ls.get(z));
			meteLista(lista,i,j,ls,z+1);
		}
	}
}
