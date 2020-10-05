package stringMethod;

public class StringMethod {

	public static String toUpper(String s) {
		return s.toUpperCase();
	}
	
	public static int nombreDeA(String string) {
		int compteur = 0;
		for(char charInString : string.toCharArray()) {
			charInString = Character.toLowerCase(charInString);
			if(charInString=='a') compteur++;
		}
		return compteur;
	}
	
	public static String transformeA(String string) {
		string = string.replace('a', '4');
		return string;
	}
	
	public static String supprimeCinqChar(String string) {
		String string1 = string.substring(0, 4);
		String string2 = string.substring(10, string.length());
		string = string1.concat(string2);
		return string;
	}
	
	public static String convertIntToString(int number) {

		return String.valueOf(number);
	}
	
	public static int convertStringToInt(String string) {

		return Integer.valueOf(string);
	}

}