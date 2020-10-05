package carryall;

public class Centaure {

	public static final int BRAS=2;
	public static final int PATTES=4;
	public static int populationCount =0;
	public int population;
	
	public Centaure() {
		this.population = populationCount++;
	}
	
	public static void main(String[] args) {
		Centaure centaure=null;
		System.out.println(Centaure.populationCount);
		
	}
}
