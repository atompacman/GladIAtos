package com.atompacman.gladiatos.ai.neuralNet;

import java.util.ArrayList;
import java.util.List;

public class HFFFNeuronLayer extends NeuronLayer {

	//------------ PRIVATE CONSTRUCTOR ------------\\

	private HFFFNeuronLayer(List<Neuron> neurons) {
		super(neurons);
	}


	//------------ PROTECTED STATIC CONSTRUCTORS ------------\\

	protected static HFFFNeuronLayer buildFrom(
			HFFFNNDescription description, 
			int layerIndex) 
					throws NeuralNetworkException {
		
		return buildFrom(description, layerIndex, null);
	}

	protected static HFFFNeuronLayer buildFrom(
			HFFFNNDescription description, 
			int layerIndex,
			double[] weights) 
					throws NeuralNetworkException {

		int nbNeurons = description.getNbNeuronsInLayer(layerIndex);
		if (nbNeurons < 1) {
			throw new NeuralNetworkException("Neuron layers must contain at least one neuron.");
		}
		int nbWeightsInNeurons = description.getNbWeightsInNeuronsOfLayer(layerIndex);
		if (nbWeightsInNeurons < 1) {
			throw new NeuralNetworkException("Neurons must contain at least two weights.");
		}
		
		NonLinearThresholder thresholder = description.getThresholder();
		List<Neuron> neurons = new ArrayList<Neuron>();
		
		if (weights != null) {
			for (int i = 0; i < nbNeurons; ++i) {
				double[] neuronWeights = new double[nbWeightsInNeurons];
				for (int j = 0; j < nbWeightsInNeurons; ++j) {
					neuronWeights[j] = weights[i * nbWeightsInNeurons + j];
				}
				neurons.add(Neuron.valueOf(neuronWeights, thresholder));
			}
		} else {
			for (int i = 0; i < nbNeurons; ++i) {
				neurons.add(Neuron.createRandom(nbWeightsInNeurons, thresholder));
			}
		}

		return new HFFFNeuronLayer(neurons);
	}


	//------------ PROCESS ------------\\

	public double[] process(double[] inputs) throws NeuralNetworkException {
		double[] outputs = new double[neurons.size()];

		for (int i = 0; i < neurons.size(); ++i) {
			outputs[i] = neurons.get(i).process(inputs);
		}

		return outputs;
	}
}
