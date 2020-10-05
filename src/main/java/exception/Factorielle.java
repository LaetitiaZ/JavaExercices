package exception;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;



public class Factorielle {

	//integer overflow after int = 12
	public int factoriel(int entier) {
		if(entier==0) return 1;
		return entier*factoriel(entier-1);
	}
	
	public long extendedFactorial(long entierLong) {
		if(entierLong==0) return 1;
		return entierLong*extendedFactorial(entierLong-1);
	}
	
	public BigInteger completeFactorial(BigInteger bigInteger) {
		if(bigInteger.equals(BigInteger.ZERO)) return BigInteger.ONE;
		return bigInteger.multiply(completeFactorial(bigInteger.subtract(BigInteger.ONE)));
	}
	
	public void checkNumber(int number) throws IncoherentException, NegativeNumberException {
		if(number>13) throw new IncoherentException();
		if(number<0) throw new NegativeNumberException();
	}
	
	public void handledFactorial(int number) {
		try {
			checkNumber(number);
			System.out.println(factoriel(number));
		}
		catch(NegativeNumberException e) {
			e.printStackTrace();
		}
		catch(IncoherentException e) {
			e.printStackTrace();
		}
	}
	
} 