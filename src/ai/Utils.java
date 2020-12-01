package ai;

/**
 * Utils for AI
 * 
 * @author timo
 *
 */
public class Utils {

	/**
	 * Sigmoid function to map all given numbers to a value between 0 and one
	 * @param val
	 * @return
	 */
	public static double sigmoid(double val) {
		return (1 / (1 + Math.pow(Math.E, (-1 * val))));
	}
}
