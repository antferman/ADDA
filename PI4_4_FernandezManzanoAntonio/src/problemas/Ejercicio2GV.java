package problemas;

import us.lsi.graphs.SimpleEdge;

public class Ejercicio2GV extends SimpleEdge<VerticeGV> {
	
	public static Ejercicio2GV of(VerticeGV v1, VerticeGV v2, Integer a) {
		Double weight = VerticeGV.numeros.get(v1.index)%2==0&& a==1?-1.0:0.;
		return new Ejercicio2GV(v1, v2, weight, a);
	}

	public Integer a;
	
	private Ejercicio2GV(VerticeGV c1, 
			VerticeGV c2, double weight, Integer a) {
		super(c1, c2, weight);
		this.a = a;
	}

	public Ejercicio2GV(VerticeGV c1, VerticeGV c2) {
		super(c1, c2);
		
	}

}