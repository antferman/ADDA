package problemas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.VirtualVertex;

	
public class VerticeGV implements VirtualVertex<VerticeGV, SimpleEdge<VerticeGV>>{
	private Integer posActual;
	private Integer[] a = {1,3,1,1,2,5,8,10,6,11,2};
	private List<Integer> numeros = Arrays.asList(a);
	private static final int n = 24;
	private Integer countPares;
	private List<Integer> solucion;
	private Integer suma;
	public static VerticeGV create(Integer... d) {
		return new VerticeGV(d);
	}

	public static VerticeGV create(Integer[][] datos, int x0, int y0) {
		return new VerticeGV(datos, x0, y0);
	}

	private VerticeGV(Integer[][] datos, int x0, int y0) {
		super();
	}
	
	public boolean isValid() {
		// TODO Auto-generated method stub
		return suma<=24;
	}

	@Override
	public Set<VerticeGV> getNeighborListOf() {
		Set<VerticeGV> ls = new HashSet<>();
		List<Integer> tmp = new ArrayList<>(solucion);
		if (posActual<numeros.size()) {
			if(numeros.get(posActual)+ suma <=24) {
				VerticeGV e VerticeGV.create();
				ls.add(e VerticeGV.create());
				if (numeros.get(posActual)%2==0) {
					countPares++;;
				}
				posActual++;
				suma = numeros.get(posActual) + suma;
			}else {
				Integer rest = tmp.get(tmp.size()-1);
				posActual--;
				tmp.remove(rest);
				VerticeGV e VerticeGV.create();
				ls.add(e);
				suma = suma-rest;
			}
		}
		return ls;
	}

	@Override
	public Set<SimpleEdge<VerticeGV>> edgesOf() {
		return getNeighborListOf().stream().map(vecino-> SimpleEdge.of(this, vecino)).collect(Collectors.toSet());
	}

}
