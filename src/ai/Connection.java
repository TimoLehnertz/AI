package ai;

/**
 * Connection class to represent the connection betwen two Neurons
 * useful for scaleable and experimental changes 
 * 
 * @author timo
 *
 */
public class Connection {

	/**
	 * Link to the next neuron wich would be fired after the owning neuron gets fired
	 */
	private Neuron link;
	/**
	 * Strength of this connection
	 * -> all trafic gets multiplied by this value so 0 means no traffic
	 * -> between 0 and 1 (sigmoid)
	 */
	private double strength = 0;
	
	/**
	 * @param link
	 * @param strength
	 */
	protected Connection(Neuron link, double strength) {
		super();
		this.link = link;
		this.strength = strength;
	}
	
	/**
	 * propagate asignal to the link if strength is > 0
	 * @param activation
	 */
	protected void fire(double activation) {
		if(strength != 0) {
			link.touch(activation * strength);
		}
	}

	/**
	 * mutate the connections strength by amount x
	 * having strength of 0.5 and plaieing mutate 0.5 means having a chance to get a strength between 0 and 1 before sigmoid gets aplied
	 * @param amount
	 */
	public void mutate(double amount) {
		double delta = (Math.random() * (amount * 2)) - amount;
		strength = Utils.sigmoid(strength + delta);
	}

	/**
	 * Resets this connection back to 0 so no communication can appear
	 */
	protected void reset() {
		strength = 0;
	}
}
