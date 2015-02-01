package com.atompacman.gladiatos.ai.neuralNet;

import java.util.List;

public abstract class FeedForwardNeuralNet extends NeuralNet {

	protected final List<NeuronLayer> hiddenLayers;
	
	
	//------------ PROTECTED CONSTRUCTOR ------------\\

	protected FeedForwardNeuralNet(List<NeuronLayer> layers, FFNNDescription description) {
		super(description);
		this.hiddenLayers = layers;
	}
	
	
	//------------ SETTERS ------------\\

	public void setInputLayer(List<Input> inputLayer) throws NeuralNetworkException {
		if (inputLayer.size() != getDescription().getNbInputs()) {
			throw new NeuralNetworkException("Neural net is set "
					+ "to have " + getDescription().getNbInputs() + " inputs "
					+ "(trying to set " + inputLayer.size() + ").");
		}
		this.inputLayer = inputLayer;
	}

	public void setOutputLayer(List<Output> outputLayer) throws NeuralNetworkException {
		if (outputLayer.size() != getDescription().getNbNeuronsInLayer(hiddenLayers.size() - 1)) {
			throw new NeuralNetworkException("Neural net must have the same number of "
					+ "outputs than the number of neurons in the last hidden layer.");
		}
		this.outputLayer = outputLayer;
	}
	
	
	//------------ GETTERS ------------\\

	public NeuronLayer getHiddenLayer(int layerIndex) {
		if (layerIndex < 0 || layerIndex >= hiddenLayers.size()) {
			throw new IllegalArgumentException("Invalid layer index \"" + layerIndex 
					+ "\": Neural net has " + hiddenLayers.size() + " hidden layers.");
		}
		return hiddenLayers.get(layerIndex);
	}
	
	public double[] getNetworkWeights() {
		double[] weights = new double[description.getTotalNbWeigths()];
		int index = 0;
		
		for (NeuronLayer layer : hiddenLayers) {
			double[] layerWeights = layer.getWeights();
			System.arraycopy(layerWeights, 0, weights, index, layerWeights.length);
			index += layerWeights.length;
		}

		return weights;
	}

	public FFNNDescription getDescription() {
		return (FFNNDescription) description;
	}
}
