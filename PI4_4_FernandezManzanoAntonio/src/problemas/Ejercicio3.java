package problemas;

import java.util.List;

import tipos.Punto;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class Ejercicio3<P> implements ProblemaPD<List<List<Punto>>, Punto, Ejercicio3<P>> {
	public static List<Punto> puntos;
	private List<List<Punto>> solucion;
	private Integer index;
	private Integer vertices;
	private Integer suma;
	
	public Tipo getTipo() {
		return Tipo.Min;
	}

	public int size() {
		return puntos.size()-3;
	}

	public boolean esCasoBase() {
		return index == puntos.size();
	}

	public Sp<Punto> getSolucionParcialCasoBase() {
		return null;
	}

	public Ejercicio3<P> getSubProblema(Punto a, int np) {
		return null;
	}

	public Sp<Punto> getSolucionParcialPorAlternativa(Punto a, List<Sp<Punto>> ls) {
		return null;
	}

	public List<Punto> getAlternativas() {
		return null;
	}

	public int getNumeroSubProblemas(Punto a) {
		return 0;
	}

	public List<List<Punto>> getSolucionReconstruidaCasoBase(Sp<Punto> sp) {
		return null;
	}

	public List<List<Punto>> getSolucionReconstruidaCasoRecursivo(Sp<Punto> sp, List<List<List<Punto>>> ls) {
		return null;
	}
}