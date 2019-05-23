package tiposPI;

public class Trayecto {
	private static int numObjs=0;
	private Double tiempo;
	private Double coste;
	private Ciudad c1,c2;
	private Integer id;
	
	public static Trayecto create() {
		return new Trayecto(null, null, null, null);
	}
	public static Trayecto create(Ciudad c1, Ciudad c2, String[] tokens) {
		return new Trayecto(Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]),c1, c2);	
	}
	public Double getTiempo() {
		return tiempo;
	}
	public Double getCoste() {
		return coste;
	}
	public Ciudad getC1() {
		return c1;
	}
	public Ciudad getC2() {
		return c2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Trayecto other = (Trayecto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Trayecto(Double tiempo, Double coste, Ciudad c1, Ciudad c2) {
		super();
		this.tiempo = tiempo;
		this.coste = coste;
		this.c1 = c1;
		this.c2 = c2;
		id = ++numObjs;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getC1().toString()+ " - " + getC2().toString() + " tiempo: " + getTiempo() + " coste: " + getCoste();
	}
}
