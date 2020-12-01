package ai;

/**
 * Neuron class to be the lowest part of an artificial neuronal network
 * 
 * @author timo
 *
 */
public class Neuron {

	/*
	 * activation of this neuron
	 */
	private double activation = 0;
	/**
	 * Connections to all neurons in the following layer or null if last layer
	 */
	private Connection[] connections;
	
	/**
	 * @param followingLayer to be connecting to(can be null if this is the last layer)
	 */
	public Neuron(Layer followingLayer) {
		super();
		if(followingLayer != null) {
			connections = followingLayer.getConnections();
		}
	}
	
	/**
	 * add activation to this neuron used for fireing process
	 * @param activation
	 */
	protected void touch(double activation) {
		this.activation += activation;
	}
	
	/**
	 * fire this neuron and let its activation propagate
	 */
	protected void fire() {
		for (Connection connection : connections) {
			connection.fire(getSigmoidActivation());
		}
	}

	/**
	 * get the activation normalized between 0 and 1
	 * Sigmoid function will be used
	 * @return
	 */
	protected double getSigmoidActivation() {
		return Utils.sigmoid(activation);
	}

	/**
	 * Absolutly set the value of this neurons activation
	 * @param activation
	 */
	protected void setActivation(double activation) {
		this.activation = activation;
	}
	
	/**
	 * Reset this neurons activation to 0
	 */
	protected void reset() {
		activation = 0;
	}

	/**
	 * mutate the connections strength by amount x
	 * having strength of 0.5 and plaieing mutate 0.5 means having a chance to get a strength between 0 and 1 before sigmoid gets aplied
	 * @param amount
	 */
	public void mutate(double amount) {
		if(connections != null) {
			for (Connection connection : connections) {
				connection.mutate(amount);
			}
		}
	}

	/**
	 * reset all connections
	 */
	public void resetConnections() {
		if(connections != null) {
			for (Connection connection : connections) {
				connection.reset();
			}
		}
	}
	
	@Override
	public String toString() {
		return "Neuron (" + activation + ")";
	}
}
