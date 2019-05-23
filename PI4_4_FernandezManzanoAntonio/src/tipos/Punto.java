package tipos;

public class Punto {

	private double x;
	private double y;
	
	public Punto(double x, double y) {
		this.x=x;
		this.y=y;
	}
	public Punto create() {
		return new Punto(0.0,0.0);
	}
	public Punto create(double x, double y) {
		return new Punto(x,y);
	}
	
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Punto other = (Punto) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public Double getDistancia(Punto a, Punto b) {
		Double res=0.;
		res = Math.sqrt(Math.pow(b.getY()-a.getY(),2) + Math.pow(b.getX()-b.getX(),2));
		return res;
	}
	
}
