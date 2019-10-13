
/**
 * RandomGenerator class and its instance methods and variables
 *
 * @author Michael Lee
 * @version 1.0
 * @since 2019/10/24
 */

import java.util.Random;

class RandomGenerator {

/**
 * creates a random number ranging between lo and hi,  
 * @param lo
 * @param hi
 * @return
 */
	int discrete(int lo, int hi)
	{
		if(lo >= hi){
			System.out.println("Error discrete, lo >= hi");
			System.exit(0);
		}
		
		Random r = new Random();
		int d = r.nextInt(hi - lo + 1) + lo;
		return d;
	}
	
}
