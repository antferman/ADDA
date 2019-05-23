package problemas;

import java.util.ArrayList;
import java.util.List;

public class SolucionEjercicio2BackTracking {

	private List<Integer> solucion;
	public static SolucionEjercicio2BackTracking create(List<Integer> sol) {
		return new SolucionEjercicio2BackTracking(sol);
	}
	private SolucionEjercicio2BackTracking(List<Integer> sol) {
		solucion = new ArrayList<>(sol);
	}
	public String toString() {
		return solucion.toString();
	}
}
