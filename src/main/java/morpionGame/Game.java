package morpionGame;
import java.util.Scanner;
import java.util.InputMismatchException;

//version du jeu de morpion sans les catch d'exception

public class Game {

	public static final int DIMENSION = 3;
	private static final int[][] plateau = new int[DIMENSION][DIMENSION];
	public static final int CODEASCIICHARACTER_A = 65;
	private static int joueurActif = 1;
	private static final int nombreJoueur =2;

	public static void main(String[] args) {
		while(!aGagne()) {
			System.out.println();
			affichePlateau();
			actionJoueur();
			changementJoueur();
		}
		affichePlateau();
		System.out.println("Joueur "+ joueurActif + " a gagn�");
	}

	private static void changementJoueur() {
		if(!aGagne()) joueurActif++;
	
		if(joueurActif > nombreJoueur ){
			joueurActif = 1;
		}
	}

	private static void actionJoueur() {
		int colonne = entreeUtilisateurColonne();
		int ligne = entreeUtilisateurLigne();
		int symboleJoueur = getSymboleJoueur(joueurActif);
		plateau[ligne][colonne]= symboleJoueur;
	}

	private static int getSymboleJoueur(int joueurNumero) {
		return joueurNumero;
	}

	public static boolean estConformeAuxDimensions(int numeroLigneOuColonne) {
		return 0<=numeroLigneOuColonne && numeroLigneOuColonne<DIMENSION;
	}
	
	public static boolean colonneAuBonFormat(char nomColonne) {
		int colonneEntier = nomColonne - CODEASCIICHARACTER_A;
		return Character.isLetter(nomColonne) && estConformeAuxDimensions(colonneEntier);
	}
	
	private static int entreeUtilisateurLigne() {
		int ligne=-1;

		Scanner scanner = new Scanner(System.in);
		while(!estConformeAuxDimensions(ligne)) {
			System.out.println("Ligne: ");
			try {
				
				ligne = scanner.nextInt()-1; 
			}
			catch(InputMismatchException e) {
				System.out.println("Please enter a number for a file");
			}
		}
		return ligne;
		
		/* String entreeUtilisateur = scanner.next();
		 * 
		 * while(!isOk(entreeUtilisateur)) {
		 * 		entreeUtilisateur=scanner.next()
		 * }
		 * 
		 * return entreeUtilisateur;
		 * 
		 * -- public boolean isOk(String entreeUtilisateur) {
		 * 			try/catch } --
		 */
	}

	private static int entreeUtilisateurColonne() {
		Scanner scanner = new Scanner(System.in);
		char nomColonne = ' ';
		
		while(!colonneAuBonFormat(nomColonne)) {
			System.out.println("Colonne: ");
			nomColonne = scanner.next().charAt(0);
		}
		
		return nomColonne - CODEASCIICHARACTER_A;
	}

	public static void afficheEnteteColonne() {
		System.out.print("   ");
		for (int i = 0; i < DIMENSION; i++) {
			System.out.print((char) (i + CODEASCIICHARACTER_A) +"  ");
		}
		System.out.println();
	}
	public static void afficheLigne(int numeroLigne) {
		System.out.print(numeroLigne+1+"  ");

		for (int numeroColonne = 0; numeroColonne < DIMENSION; numeroColonne++) {
			System.out.print(plateau[numeroLigne][numeroColonne]+"  ");
		}
		System.out.println();
	}
	public static void affichePlateau() {
		afficheEnteteColonne();
		for (int numeroLigne = 0; numeroLigne < DIMENSION; numeroLigne++) {
			afficheLigne(numeroLigne);
		}
		System.out.println();
	}
	
	public static boolean aGagne() {
		return possedeUneColonneComplete() || possedeUneLigneComplete() || possedeUneDiagonaleComplete();
	}

	private static boolean possedeUneDiagonaleComplete() {
		return aDiagonaleHauteComplete() || aDiagonaleBasseComplete();
	}
	
	public static boolean aDiagonaleHauteComplete() {
		int debutDiagonale = plateau[0][0];
		boolean estDiagonaleComplete = debutDiagonale !=0;
		
		for(int i=0; i<DIMENSION; i++) {
			estDiagonaleComplete &= debutDiagonale == plateau[i][i];
		}
		
		return estDiagonaleComplete;
	}
	
	public static boolean aDiagonaleBasseComplete() {
		int indexLigneDebutDiagonale=DIMENSION-1;
		int indexColonneDebutDiagonale=0;
		int debutDiagonale = plateau[indexLigneDebutDiagonale][indexColonneDebutDiagonale];
		boolean estDiagonaleComplete = debutDiagonale !=0;
		
		for(int numeroLigne=0; numeroLigne<DIMENSION;numeroLigne++) {
			estDiagonaleComplete &= debutDiagonale == plateau[indexLigneDebutDiagonale-numeroLigne][indexColonneDebutDiagonale+numeroLigne];
		} 
		
		return estDiagonaleComplete;
	}


	private static boolean possedeUneLigneComplete() {
		for (int numeroLigne = 0; numeroLigne < DIMENSION; numeroLigne++) {
			if (estLigneComplete(numeroLigne)) {
				return true;
			}
		}
		
		return false;
	}

	private static boolean estLigneComplete(int numeroLigne) {
		int[] ligne = plateau[numeroLigne];
		int premiereValeur = ligne[0];
		boolean estLigneComplete = premiereValeur != 0;

		for (int numeroColonne = 0; numeroColonne < DIMENSION; numeroColonne++) {
			
			estLigneComplete &= premiereValeur == ligne[numeroColonne];
		}
		
		return estLigneComplete;
	}

	private static boolean possedeUneColonneComplete() {
		for(int numeroColonne=0; numeroColonne<DIMENSION; numeroColonne++) {
			if(estColonneComplete(numeroColonne)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean estColonneComplete(int numeroColonne) {
		int premiereValeur = plateau[0][numeroColonne];
		boolean estColonneComplete = premiereValeur != 0;
		
		for(int numeroLigne=0; numeroLigne<DIMENSION; numeroLigne++) {
			estColonneComplete &= premiereValeur == plateau[numeroLigne][numeroColonne];
		}
		
		return estColonneComplete;
	}
}
