package com.atompacman.gladiatos.ai.neuralNet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestNeuron {
	
	private static final double EPSILON = 1e-10;
	
	
	//------------ PROCESS ------------\\
	
	@Test
	public void case1() throws NeuralNetworkException {
		double[] weights = {1.0, 2.0, Neuron.INITIAL_BIAS};
		Neuron neuron = Neuron.valueOf(weights, NonLinearThresholder.SIGMOID);
		double[] input = {2.3, -1.5};
		assertEquals(neuron.process(input), 0.33181222783183384, EPSILON);
	}
}
