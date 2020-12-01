package ai;

/**
 * Layer class to represent a layer of neurons in a Network
 * 
 * @author timo
 *
 */
public class Layer {

	/**
	 * The heart of every Layer
	 */
	private Neuron[] neurons;
	
	/**
	 * 
	 * @param size
	 * @param nextLayer (can be null)
	 */
	public Layer(int size, Layer nextLayer) {
		super();
		neurons = new Neuron[size];
		for (int i = 0; i < size; i++) {
			neurons[i] = new Neuron(nextLayer);
		}
	}
	
	/**
	 * get all activations from this layers neurons with sigmoid function aplied
	 * used for getting the result after an operation from th last layer
	 */
	public double[] getResult() {
		double[] result = new double[neurons.length];
		for (int i = 0; i < neurons.length; i++) {
			result[i] = neurons[i].getSigmoidActivation();
		}
		return result;
	}
	
	/**
	 * get the size of this layer
	 * @return
	 */
	protected int getSize() {
		return neurons.length;
	}
	
	/**
	 * used for initialization of neurons in the previous layer
	 * @return
	 */
	protected Connection[] getConnections(){
		Connection[] connections = new Connection[neurons.length];
		for (int i = 0; i < connections.length; i++) {
			connections[i] = new Connection(neurons[i], 0);
		}
		return connections;
	}
	
	/**
	 * fire all neurons in this layer
	 */
	protected void fire() {
		for (Neuron neuron : neurons) {
			neuron.fire();
		}
	}
	
	/**
	 * reset all neurons activation to 0
	 */
	protected void reset() {
		for (Neuron neuron : neurons) {
			neuron.reset();
		}
	}

	/**
	 * set the activation of all neurons
	 * used to set the input activations of the first layer
	 * @param input
	 */
	protected void setInput(double[] input) {
		for (int i = 0; i < input.length; i++) {
			neurons[i].setActivation(input[i]);
		}
	}

	/**
	 * mutate the connections strength by amount x
	 * having strength of 0.5 and plaieing mutate 0.5 means having a chance to get a strength between 0 and 1 before sigmoid gets aplied
	 * @param amount
	 */
	protected void mutate(double amount) {
		for (Neuron neuron : neurons) {
			neuron.mutate(amount);
		}
	}

	/**
	 * Reset all connections
	 */
	protected void resetConnections() {
		for (Neuron neuron : neurons) {
			neuron.resetConnections();
		}
	}
	
	@Override
	public String toString() {
		return "Layer w " + neurons.length + " Neurons";
	}
}
