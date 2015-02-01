package com.atompacman.gladiatos.ai.neuralNet;

import java.util.List;

public abstract class NeuronLayer {

	protected final List<Neuron> neurons;
	protected final int totalNbWeights;
	
	
	//------------ PROTECTED CONSTRUCTOR ------------\\
	
	protected NeuronLayer(List<Neuron> neurons) {
		this.neurons = neurons;
		
		int totalNbWeights = 0;
		for (Neuron neuron : neurons) {
			totalNbWeights += neuron.getTotalNbWeights();
		}
		
		this.totalNbWeights = totalNbWeights;
	}

	
	//------------ PROCESS ------------\\

	public abstract double[] process(double[] inputs) throws NeuralNetworkException;
	

	//------------ GETTERS ------------\\

	public Neuron getNeuron(int neuronIndex) {
		if (neuronIndex < 0 || neuronIndex >= getNbNeurons()) {
			throw new IllegalArgumentException("Invalid neuron index \"" + neuronIndex 
					+ "\": Neuron layer has " + getNbNeurons() + " neurons.");
		}
		return neurons.get(neuronIndex);
	}
	
	public int getNbNeurons() {
		return neurons.size();
	}

	public double[] getWeights() {
		double[] weights = new double[totalNbWeights];
		int index = 0;
		
		for (Neuron neuron : neurons) {
			double[] neuronWeights = neuron.getWeights();
			System.arraycopy(neuronWeights, 0, weights, index, neuronWeights.length);
			index += neuronWeights.length;
		}

		return weights;
	}
	
	public int getNbWeights() {
		return totalNbWeights;
	}
}
