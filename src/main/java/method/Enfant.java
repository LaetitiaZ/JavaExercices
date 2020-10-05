package method;

public class Enfant {

	
	private String nom;
	private String prenom;
	private int age=0;
	private String amoureux;
	
	public Enfant(String prenom, String nom) {
		this.nom = nom;
		this.prenom = prenom;
	
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public void presentation() {
		System.out.println("Bonjour, je m'appelle "+this.prenom+" "+this.nom+" et j'ai "+this.age+" ans");
	}
	
	public void feterAnniversaire() {
		if(age<17)
		this.age+=1;
	}
	
	public void joueAuBallon(Enfant enfant) {
		System.out.println(this.prenom+" joue au ballon avec "+enfant.prenom);
	}
	
	public void tomberAmoureux(Enfant enfant) {
		this.amoureux=enfant.prenom;
		System.out.println(this.prenom+" est tomb� amoureux de "+enfant.prenom);
	}
	
	public boolean estAmoureux() {
		return (this.amoureux!=null);
	}
	
	public static void main(String[] args) {
		
		Enfant cha = new Enfant("Charlotte", "Rosier");
		Enfant oli = new Enfant("Olivier", "Guib");
		cha.feterAnniversaire();
		cha.feterAnniversaire();	
		cha.presentation();
		cha.joueAuBallon(oli);
		cha.tomberAmoureux(oli);
		oli.tomberAmoureux(cha);
	
	}
}
