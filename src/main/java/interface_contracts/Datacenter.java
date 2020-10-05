package interface_contracts;

public class Datacenter implements AvecClimatisation {

	double temperature;
	
	public Datacenter(double temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public void refroidir() {
		this.temperature = 20.0;
	}
	
}
