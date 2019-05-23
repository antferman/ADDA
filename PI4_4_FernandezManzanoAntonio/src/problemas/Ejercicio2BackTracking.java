package problemas;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.EstadoBT;

public class Ejercicio2BackTracking implements EstadoBT<SolucionEjercicio2BackTracking, Integer, Ejercicio2BackTracking>{
	
	private List<Integer> solucion;
	private Integer index;
	private Integer countPares;
	private Integer suma;
	
	public Tipo getTipo() {
		return EstadoBT.Tipo.Max;
	}

	public static Ejercicio2BackTracking create() {
		return new Ejercicio2BackTracking();
	}

	private Ejercicio2BackTracking() {
		solucion = new ArrayList<>();
		index=0;
		countPares=0;
		suma=0;
	}
	
	public Ejercicio2BackTracking getEstadoInicial() {
		return create();
	}

	public Ejercicio2BackTracking avanza(Integer a) {
		Integer e = Ejercicio2BT.numeros.get(index);
		if (a==1) {
			solucion.add(e);
			if(e%2==0) {
				countPares++;
			}
			suma = suma + e;
		}
		index ++;
		return this;
	}

	public Ejercicio2BackTracking retrocede(Integer a) {
		index--;
		Integer e = Ejercicio2BT.numeros.get(index);
		
		if (a==1) {
			if(e%2==0) {
				countPares--;
			}
			
			suma=suma-e;
			solucion.remove(solucion.size()-1);
		}
		return this;
	}
	public int size() {
		return Ejercicio2BT.numeros.size()-index;
	}
	
	public boolean esCasoBase() {
		return index == Ejercicio2BT.numeros.size();
	}

	public List<Integer> getAlternativas() {
		List<Integer> ls = new ArrayList<>();
		ls.add(0);
		if (Ejercicio2BT.numeros.get(index) + suma <=Ejercicio2BT.n) {
			ls.add(1);
		}
		return ls;
	}
	
	public SolucionEjercicio2BackTracking getSolucion() {
		if (suma==Ejercicio2BT.n) {
			return SolucionEjercicio2BackTracking.create(solucion);
		}
		return null;
	}
	
	public Double getObjetivo() {
		return (double)countPares;
	}
	

}
