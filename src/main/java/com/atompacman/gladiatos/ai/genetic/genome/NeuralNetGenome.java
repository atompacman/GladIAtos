package com.atompacman.gladiatos.ai.genetic.genome;

import com.atompacman.gladiatos.ai.neuralNet.NeuralNet;

public class NeuralNetGenome extends Genome<Double> {

	private NeuralNet neuralNet;
	
	
	//------------ CONSTRUCTOR ------------\\

	public NeuralNetGenome(NeuralNet associatedNeuralNet) {
		this.neuralNet = associatedNeuralNet;
	}
	
	
	//------------ GETTERS ------------\\

	public Double[] getDNA() {
		Double[] weights = new Double[neuralNet.getDescription().getTotalNbWeigths()];
		double[] weightsArray = neuralNet.getNetworkWeights();
		
		for (int i = 0; i < weightsArray.length; ++i) {
			weights[i] = weightsArray[i];
		}
		
		return weights;
	}
}
