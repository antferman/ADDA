package problemas;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Lists2;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class Ejercicio2PDR implements ProblemaPDR<List<Integer>, Integer, Ejercicio2PDR>{
	public static List<Integer> numeros;
	public static final Integer n=24;
	private List<Integer> solucion;
	private Integer countPares;
	private Integer index;
	private Integer suma;
	
	public static Ejercicio2PDR create (List<Integer> ls) {
		Ejercicio2PDR.numeros = ls;
		return new Ejercicio2PDR(new ArrayList<>(),0,0,0);
	}
	
	
	public static Ejercicio2PDR create(List<Integer> solucion, Integer countPares, Integer sum, Integer index) {
		return new Ejercicio2PDR(solucion,countPares,sum,index);
	}

	private Ejercicio2PDR(List<Integer> solucion, Integer countPares, Integer sum, Integer index) {
		super();
		this.index=index;
		this.solucion= solucion;
		this.countPares=countPares;
		this.suma=sum;
	}

	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return Tipo.Max;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return solucion.size()-index;
	}

	@Override
	public boolean esCasoBase() {

		return index==numeros.size();
	}

	

	@Override
	public Ejercicio2PDR getSubProblema(Integer a) {
		
		List<Integer> nSol = Lists2.newList(this.solucion);
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
		
		return Ejercicio2PDR.create(nSol, nPares, nSuma, index+1);
	}
	

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		Integer e = numeros.get(index);

		if (a==1 && e%2==0) {
		   return Sp.create(a, s.propiedad+1);
		}
		return Sp.create(a, s.propiedad);

	}

	@Override
	public List<Integer> getAlternativas() {
		List<Integer> ls = new ArrayList<>();
		ls.add(0);
		if (numeros.get(index) + suma <=n) {
			ls.add(1);
		}
		return ls;
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> s) {
		Integer e = numeros.get(index);
        if (sp.alternativa==1) {
		  s.add(e);
        }
		return s;
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
		Ejercicio2PDR other = (Ejercicio2PDR) obj;
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


	public Sp<Integer> getSolucionParcialCasoBase() {
		if (suma==n) {
			return Sp.create(null, 0.);
		}
		return null;
	}
	
	
}
