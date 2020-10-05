package abstractClass;

public class Vehicule {

	private int nombreRoues;
	
	public Vehicule(int nombreRoues) {

		this.nombreRoues = nombreRoues;
	}
	
	@Override
	public String toString() {
		return "Bonjour je suis un véhicule à "+nombreRoues+" roues";
	}
}
