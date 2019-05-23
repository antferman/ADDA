package tiposPI;

public class Ciudad {
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Ciudad other = (Ciudad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public static Ciudad create(String[] tokens) {
		return new Ciudad(tokens[0]);
	}
	
	public static Ciudad create (String o) {
		return new Ciudad(o);
	}
	public static Ciudad create() {
		return new Ciudad(null);
	}
}
