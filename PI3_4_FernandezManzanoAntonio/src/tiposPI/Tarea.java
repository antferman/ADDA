package tiposPI;

public class Tarea {
	private static int numObjs =0;
	public Integer getId() {
		return id;
	}
	private Integer duracion;
	private Integer id=0;
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		return true;
	}

	public Integer getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "Tarea "+ id +" [duracion=" + duracion + "]";
	}
	

	public Tarea(Integer duracion) {
		this.duracion = duracion;
		id=++numObjs;
	}
	public static Tarea create (Integer duracion) {
		return new Tarea(duracion);
	}
	public static Tarea create (String s) {
		String[] partes = s.split(",");
		Integer dura=Integer.parseInt(partes[0]);
		return new Tarea(dura);
	}
	
}
