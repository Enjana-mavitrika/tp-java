package dessin;

public interface Forme {
	public abstract double perimetre();
	public abstract double surface();
	public abstract boolean dedans(Point p);
	public abstract void translater(double dx, double dy);
}
