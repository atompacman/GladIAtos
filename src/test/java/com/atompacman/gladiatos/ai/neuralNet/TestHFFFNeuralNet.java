package com.atompacman.gladiatos.ai.neuralNet;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestHFFFNeuralNet {

	private static final NonLinearThresholder TEST_THRESHOLDER = NonLinearThresholder.SIGMOID;
	
	
	//------------ PROCESS ------------\\

	@Test
	public void case1() throws NeuralNetworkException {
		double[][][] weights = 
			{{{ 0.5, 0.2,  0.4,  0.3},
				{-0.1, 0.2,  0.4,  0.3},
				{ 0.7, 0.25, 0.2,  0.5},
				{-0.5, 0.2,  0.05, 0.5}}, 

				{{ 0.25, 0.2, 0.1,  0.3},
				{-0.1, -0.2, 0.4, -0.3},
				{ 0.7,  0.8, 0.2,  0.5},
				{-0.5,  0.2, 0.7,  0.5}}};

		HFFFNeuralNet net = buildTestNet(weights, 4);

		double[] inputs = {4, 15, 0.3, -4.5};
		double[] outputs = net.process(inputs);
		double[] predictedOutput = predictOutputs(inputs, weights);

		assertTrue(Arrays.equals(outputs, predictedOutput));
	}


	//------------ UTILS ------------\\

	public static HFFFNeuralNet buildTestNet(
			double[][][] weights, 
			int nbInputs) 
					throws NeuralNetworkException {
		List<Double> allWeights = new ArrayList<Double>();
		List<Integer> nbNeuronsInLayers = new ArrayList<Integer>();

		for (double[][] weightsInLayer : weights) {
			nbNeuronsInLayers.add(weightsInLayer.length);

			for (double[] weightsInNeuron : weightsInLayer) {
				for (double aWeight : weightsInNeuron) {
					allWeights.add(aWeight);
				}
				allWeights.add(Neuron.INITIAL_BIAS);
			}
		}
		
		HFFFNNDescription desc = 
				HFFFNNDescription.specifiedBy(nbNeuronsInLayers, nbInputs, TEST_THRESHOLDER);

		double[] allTheWeights = new double[allWeights.size()];
		for (int i = 0; i < allWeights.size(); ++i) {
			allTheWeights[i] = allWeights.get(i);
		}
		
		HFFFNeuralNet net = HFFFNeuralNet.buildFrom(desc, allTheWeights);
		
		List<Input> inputs = new ArrayList<Input>();
		for (int i = 0; i < nbInputs; ++i) {
			inputs.add(new Input());
		}
		net.setInputLayer(inputs);
		
		return net;
	}

	public static double[] predictOutputs(double[] inputs, double[][][] weights) {
		List<Double> tempRead = new ArrayList<Double>();
		List<Double> tempWrite = new ArrayList<Double>();

		for (double input : inputs) {
			tempRead.add(input);
		}

		for (int i = 0; i < weights.length; ++i) {
			tempWrite.clear();
			for (int j = 0; j < weights[i].length; ++j) {
				double cumul = 0;
				for (int k = 0; k < weights[i][j].length; ++k) {
					cumul += weights[i][j][k] * tempRead.get(k);
				}
				tempWrite.add(TEST_THRESHOLDER.apply(cumul));
			}
			tempRead = new ArrayList<Double>(tempWrite);
		}

		double[] outputs = new double[weights[weights.length - 1].length];
		for (int i = 0; i < tempRead.size(); ++i) {
			outputs[i] = tempRead.get(i);
		}

		return outputs;
	}
}
