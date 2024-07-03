package Generric_Utilities;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * its used to generate the random number with in the range of 1000
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author hp
	 */
	
	public int getRandowNumber() {
		
		Random ranNum = new Random();
		int ranNumber = ranNum.nextInt();
		return ranNumber;
			
	}

}