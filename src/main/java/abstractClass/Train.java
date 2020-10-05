package abstractClass;

public class Train extends Vehicule {

	public Train() {
		super(100);
	}
	
	@Override
	public String toString() {
		return super.toString() + " \nTchooTchoo! ";
		
	}
	
	public static void main(String[] args) {
		Train train = new Train();
		System.out.println(train);
	}
}
