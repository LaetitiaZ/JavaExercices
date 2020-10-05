package collection;
import java.util.Comparator;

public class VoyageComparator implements Comparator<Voyageur> {

	public int compare(Voyageur v1, Voyageur v2) {
		System.out.println(v1.id + "  " + v2.id);
		
		int byClasse = v1.classe.compareTo(v2.classe);
		int bySiege = v1.numeroSiege.compareTo(v2.numeroSiege);
		if(byClasse==0) {
			System.out.println("siege " + bySiege);
			return bySiege;
		}
		System.out.println("classe " + byClasse);
		return byClasse;
	} 
}
