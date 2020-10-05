package interface_contracts;

public class Maison implements AvecChauffage, AvecClimatisation{

	double temperature;
	
	public Maison(double temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public void chauffer() {
		this.temperature +=1;
	}
	
	@Override
	public void refroidir() {
		this.temperature -=1;
	}
}
