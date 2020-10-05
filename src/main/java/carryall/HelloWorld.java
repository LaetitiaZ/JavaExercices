package carryall;
import java.util.Random;
import java.util.ArrayList;

public class HelloWorld {
	
	

	public static void main(String[] args ) {
	
	String[] chaines = new String[3];
	chaines[0] ="good";
	chaines[1] ="morning";
	chaines[2] ="world";
	
	for(int i=0; i<chaines.length;i++) {
		System.out.print(chaines[i]+" ");
	}

	System.out.println();
	
	
	String[][][] chainesMulti = new String[2][2][2];
	
	Random random = new Random();
	
	for(int i=0; i<chainesMulti[0].length;i++) {
		for(int j=0; j<chainesMulti[1].length;j++) {
			for(int k=0; k<chainesMulti[0][1].length;k++)
			{
				chainesMulti[i][j][k] =String.valueOf(random.nextInt());
			}
		}
	}
	
	}
	
	
	
	public static void inverseNb(int a, int b) {
		int temp = a;
		a=b;
		b=temp;
		System.out.println(a+" "+b);
	}
	
	public static int partieEnt(int a, int b) {
		return (int) a/b;
		
	}
	
	public static void divisible(int a) {
		
		if((a%3==0 && a%5==0) || a%7==0 ) {
			System.out.println("divisible par 3 et 5 ou par 7");
		}
		else {
			System.out.println("non divisible par 3 et 5 ou par 7");
		}
	}
	
	public static String premierArg(String... someStrings) {
		return someStrings[0];
	}
	
	public static int addition(int a, int b) {
		return a+b;
	}
	
	//Externaliser 
	
	public static void diviser(int a, int b) {
		switch(b) {
		case 0: 
			System.out.println("diviseur 0 interdit");
			break;
		default:
			double c=a/b;
			System.out.println("result ="+c);
		}
	}
	
	public static void boucleInfinie() {
		while(true) {
			//some code
		}
	}
	
	public static int factorielle(int n) {
		if(n==0) {
			return 1;
		}
		else {
			return factorielle(n-1)*n;
		}
	}
	
	public static void rectangle(int a, int b) {
		for(int i=0; i<b;i++) {
			System.out.println();
			for (int j=0; j<a; j++) {
				System.out.print("0");
			}
		}
	}
	
	public static ArrayList<Integer> addToArray(ArrayList<Integer> l, int a) {
		
		l.add(a);
		return l;
	}
	
	public static int somme(int... someInts) {
		int c=0;
		for(int i=0; i<someInts.length;i++) {
			c+=someInts[i];
		}
		return c;
	}
}
