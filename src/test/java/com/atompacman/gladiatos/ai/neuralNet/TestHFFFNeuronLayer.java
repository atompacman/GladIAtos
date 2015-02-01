package com.atompacman.gladiatos.ai.neuralNet;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class TestHFFFNeuronLayer {
		
	//------------ PROCESS ------------\\

	@Test
	public void case1() throws NeuralNetworkException {
		double[][] layer1 = 
			{{ 0.5, 0.2,  0.4,  0.3},
			 {-0.1, 0.2,  0.4,  0.3},
			 { 0.7, 0.25, 0.2,  0.5},
			 {-0.5, 0.2,  0.05, 0.5}};
		
		double[] inputs = {4, 15, 0.3, -4.5};
		NeuronLayer layer = buildTestLayer(inputs.length, layer1, NonLinearThresholder.SIGMOID);
		double[] outputs = layer.process(inputs);

		assertEquals(4, outputs.length);
		assertEquals(0.9873828393206613, outputs[2], NNParameters.EPSILON);
	}
	
	
	//------------ UTILS ------------\\

	private static NeuronLayer buildTestLayer(
			int nbInputs, 
			double[][] weights, 
			NonLinearThresholder thresholder) 
					throws NeuralNetworkException {

		double[] allWeights = new double[weights.length * (weights[0].length + 1)];

		for (int x = 0; x < weights.length; ++x) {
			for (int y = 0; y < weights[0].length; ++y) {
				allWeights[x * (weights.length + 1) + y] = weights[x][y];
			}
			allWeights[x * (weights.length + 1) + weights[0].length] = Neuron.INITIAL_BIAS;
		}
		
		HFFFNNDescription desc = 
				HFFFNNDescription.specifiedBy(Arrays.asList(weights.length), nbInputs, thresholder);

		return HFFFNeuronLayer.buildFrom(desc, 0, allWeights);
	}
}
