package ai;

import java.util.List;

/**
 * Artificial neuronal network
 * 
 * contains layers wich contain Neurons
 * 
 * @author timo
 *
 */
public class Network {

	/**
	 * Layers to store all information
	 */
	private Layer[] layers;
	
	/**
	 * 
	 * @param structure
	 */
	public Network(List<Integer> structure) {
		super();
		layers = new Layer[structure.size()];
		Layer nextLayer = null;
		/**
		 * iterating backwards to know the next layer for initialization of connections
		 */
		for (int i = structure.size() - 1; i >= 0; i--) {
			layers[i] = new Layer(structure.get(i), nextLayer);
			nextLayer = layers[i];
		}
		randomizeConnections();
	}
	
	/**
	 * absolutly randomize all connection strengths
	 */
	public void randomizeConnections() {
		resetConnections();
		mutate(1);
	}
	
	/**
	 * mutate all connections strength by amount x
	 * having strength of 0.5 and plaieing mutate 0.5 means having a chance to get a strength between 0 and 1 before sigmoid gets aplied
	 * @param amount
	 */
	public void mutate(double amount) {
		for (Layer layer : layers) {
			layer.mutate(amount);
		}
	}
	
	/**
	 * Resets all connections back to 0
	 */
	private void resetConnections() {
		for (Layer layer : layers) {
			layer.resetConnections();
		}
	}
	
	/**
	 * set the first layers neurons to the given valus
	 * @param input
	 * @return true for succsess
	 */
	public boolean setInput(double[] input) {
		if(input.length != layers.length) {
			return false;
		}
		layers[0].setInput(input);
		return true;
	}
	
	/**
	 * get the lasts layers neurons activations
	 * -> sigmoid function will be applied
	 * @return
	 */
	public double[] getResult() {
		return layers[layers.length - 1].getResult();
	}
	
	/**
	 * fires all neurons in the first layer
	 * @return succsess
	 */
	public boolean fire() {
		if(layers.length > 0) {
			layers[0].fire();
			return true;
		}
		return false;
	}
	
	/**
	 * resets all layers wich will reset all neurons to 0
	 */
	public void reset() {
		for (Layer layer : layers) {
			layer.reset();
		}
	}
	
	@Override
	public String toString() {
		return "AI net " + layers.length + " layers";
	}
}
