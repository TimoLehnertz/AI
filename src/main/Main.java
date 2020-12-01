package main;

import java.util.Arrays;

import ai.Network;

public class Main {

	public static void main(String[] args) {
		Network n = new Network(Arrays.asList(5, 10, 5));
		double[] input = {1,2,3,4,5};
//		n.setInput(input);
//		n.fire();
		System.out.println(Arrays.toString(n.getResult()));
	}
}