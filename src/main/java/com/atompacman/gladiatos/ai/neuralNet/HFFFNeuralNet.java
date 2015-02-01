package com.atompacman.gladiatos.ai.neuralNet;

import java.util.ArrayList;
import java.util.List;

public final class HFFFNeuralNet extends FeedForwardNeuralNet {

	//------------ PRIVATE CONSTRUCTOR ------------\\

	private HFFFNeuralNet(List<NeuronLayer> layers, HFFFNNDescription description) {
		super(layers, description);
	}


	//------------ STATIC CONSTRUCTORS ------------\\

	public static HFFFNeuralNet buildFrom(
			HFFFNNDescription description) 
					throws NeuralNetworkException {

		return buildFrom(description, null, null, null);
	}

	public static HFFFNeuralNet buildFrom(
			HFFFNNDescription description, 
			List<Input> inputs, 
			List<Output> outputs) 
					throws NeuralNetworkException {

		return buildFrom(description, inputs, outputs, null);
	}

	public static HFFFNeuralNet buildFrom(
			HFFFNNDescription description, 
			double[] weights) 
					throws NeuralNetworkException {
		
		return buildFrom(description, null, null, weights);
	}

	public static HFFFNeuralNet buildFrom(
			HFFFNNDescription description, 
			List<Input> inputs, 
			List<Output> outputs,
			double[] weights) 
					throws NeuralNetworkException {

		if (description.getNbHiddenLayers() == 0) {
			throw new NeuralNetworkException("Neural net must have at least one hidden layer.");
		}

		List<NeuronLayer> hiddenLayers = new ArrayList<NeuronLayer>();

		if (weights != null) {
			if (weights.length != description.getTotalNbWeigths()) {
				throw new NeuralNetworkException("The number of weights provided (" 
						+ weights.length + ") is not equal to the number of weights "
						+ "in the neural net (" + description.getTotalNbWeigths() + ").");
			}
		}

		int weightsIndex = 0;
		for (int i = 0; i < description.getNbHiddenLayers(); ++i) {
			if (weights != null) {
				int nbWeights = description.getNbWeightsInLayer(i);
				double[] layerWeights = new double[nbWeights];
				System.arraycopy(weights, weightsIndex, layerWeights, 0, nbWeights);
				hiddenLayers.add(HFFFNeuronLayer.buildFrom(description, i, layerWeights));
				weightsIndex += nbWeights;
			} else {
				hiddenLayers.add(HFFFNeuronLayer.buildFrom(description, i));
			}
		}

		HFFFNeuralNet net = new HFFFNeuralNet(hiddenLayers, description);

		if (inputs != null) {
			if (inputs.isEmpty()) {
				throw new NeuralNetworkException("Neural net must have at least one input.");
			}
			net.setInputLayer(inputs);
		}
		if (outputs != null) {
			if (outputs.size() != description.getNbOutputs()) {
				throw new NeuralNetworkException("Neural net must have the same number of "
						+ "outputs than the number of neurons in the last hidden layer.");
			}
			net.setOutputLayer(outputs);
		}

		return net;
	}


	//------------ PROCESS ------------\\

	public double[] process(double[] inputs) throws NeuralNetworkException {
		if (inputs.length != super.inputLayer.size()) {
			throw new NeuralNetworkException("Input size (" + inputs.length + ") must match the "
					+ "number of inputs of the neural network (" + super.inputLayer.size() + ").");
		}

		double[] output = hiddenLayers.get(0).process(inputs);

		for (int i = 1; i < hiddenLayers.size(); ++i) {
			output = hiddenLayers.get(i).process(output);
		}

		return output;
	}


	//------------ GETTERS ------------\\

	public HFFFNNDescription getDescription() {
		return (HFFFNNDescription) description;
	}
}