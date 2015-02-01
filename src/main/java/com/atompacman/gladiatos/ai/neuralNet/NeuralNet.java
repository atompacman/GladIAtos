package com.atompacman.gladiatos.ai.neuralNet;

import java.util.List;

public abstract class NeuralNet {

	protected List<Input> 	inputLayer;
	protected List<Output> 	outputLayer;

	protected final NeuralNetDescription description;


	//------------ PROTECTED CONSTRUCTOR ------------\\

	protected NeuralNet(NeuralNetDescription description) {
		this.description = description;
	}


	//------------ PROCESS ------------\\

	public abstract double[] process(double[] inputs) throws NeuralNetworkException;


	//------------ SETTERS ------------\\

	public abstract void setInputLayer(List<Input> inputLayer) throws NeuralNetworkException;

	public abstract void setOutputLayer(List<Output> outputLayer) throws NeuralNetworkException;


	//------------ GETTERS ------------\\

	public Input getInput(int inputIndex) {
		if (inputLayer == null) {
			throw new IllegalArgumentException("No inputs were set for this neural net.");
		}
		if (inputIndex < 0 || inputIndex >= inputLayer.size()) {
			throw new IllegalArgumentException("Invalid input index \"" + inputIndex 
					+ "\": Neural net has " + inputLayer.size() + " inputs.");
		}
		return inputLayer.get(inputIndex);
	}

	public Output getOutput(int outputIndex) {
		if (outputLayer == null) {
			throw new IllegalArgumentException("No outputs were set for this neural net.");
		}
		if (outputIndex < 0 || outputIndex >= outputLayer.size()) {
			throw new IllegalArgumentException("Invalid output index \"" + outputIndex 
					+ "\": Neural net has " + outputLayer.size() + " outputs.");
		}
		return outputLayer.get(outputIndex);
	}

	public abstract double[] getNetworkWeights();

	public NeuralNetDescription getDescription() {
		return description;
	}
}
