package problemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.*;

import us.lsi.common.Lists2;
import us.lsi.graphs.*;




public class VerticeGV extends ActionVirtualVertex<VerticeGV, Ejercicio2GV, Integer> {

	public static VerticeGV of() {
		return new VerticeGV(0, 0, 0, new ArrayList<>());
	}
	
	public static VerticeGV of(Integer index, Integer suma, Integer countPares,List<Integer> sol) {
		return new VerticeGV(index, suma, countPares, sol);
	}

	private static final Integer[] num = {1,3,1,1,2,5,8,10,6,11};
	public static List<Integer> numeros = Arrays.asList(num);
	public static final Integer n=24;
	public List<Integer> solucion;
	public Integer countPares;
	public Integer index;
	public Integer suma;
	
	public VerticeGV(Integer index, Integer suma, Integer countPares, List<Integer> sol) {
		super();
		this.index = index;
		this.suma= suma;
		this.countPares=countPares;
		this.solucion=sol;
	}

	public List<Integer> getSolucion(){
		List<Integer> s = new ArrayList<>(solucion);
		return s;
	}

	
	@Override
	public boolean isValid() {
		return index>=0 && index<numeros.size()-1;
	}

	@Override
	protected List<Integer> actions() {
		List<Integer> ls = new ArrayList<>();
		if (index<numeros.size()) {
			ls.add(0);
		
		if (numeros.get(index) + suma <=n) {
			ls.add(1);
		}
		}
		return ls;
	}

	@Override
	protected VerticeGV getThis() {
		return this;
	}

	@Override
	protected VerticeGV neighbor(Integer a) {
		List<Integer> nSol = Lists2.newList(solucion);
		Integer e = numeros.get(index);
		Integer nPares = countPares;
		Integer nSuma = suma;
		if(a==1) {
			nSol.add(e);
			if (e%2==0) {
				nPares++;
			}
			nSuma = nSuma + e;
		}	
		
		return VerticeGV.of(index+1, nSuma, nPares, nSol);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countPares == null) ? 0 : countPares.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((solucion == null) ? 0 : solucion.hashCode());
		result = prime * result + ((suma == null) ? 0 : suma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerticeGV other = (VerticeGV) obj;
		if (countPares == null) {
			if (other.countPares != null)
				return false;
		} else if (!countPares.equals(other.countPares))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (solucion == null) {
			if (other.solucion != null)
				return false;
		} else if (!solucion.equals(other.solucion))
			return false;
		if (suma == null) {
			if (other.suma != null)
				return false;
		} else if (!suma.equals(other.suma))
			return false;
		return true;
	}

	@Override
	protected Ejercicio2GV getEdge(Integer a) {
		return Ejercicio2GV.of(this, neighbor(a), a);
	}
	
}