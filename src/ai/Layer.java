package ai;

/**
 * General abstract layer class for all Artificial neuronal network layers
 * All layers contained in an ANN get initialized with their next sibling or null in case of beeing last layer
 * 
 * All layers have a specific amount of inputs and a specified amount of outputs
 * what happens inside the layer is beeing defined in the various implementations
 * 
 * 
 * 
 * @author Timo Lehnertz
 *
 */
public abstract class Layer {

	
	/**
	 * Return the amount of output signals
	 * should return the same as getOutputSize() for simple layers
	 * @return
	 */
	public abstract int getInputSize();
	
	/**
	 * Return the amount of input signals
	 * should return the same as getInputSize() for simple layers
	 * @return
	 */
	public abstract int getOutputSize();
}