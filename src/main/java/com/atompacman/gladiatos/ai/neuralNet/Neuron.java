package com.atompacman.gladiatos.ai.neuralNet;

import com.atompacman.gladiatos.ai.util.RandNumGen;

public class Neuron {

	protected static final double INITIAL_BIAS = 0;
	protected static final double INIT_RAND_WEIGHT_RANGE = 1;
	
	
	private final double[] weights;
	private final NonLinearThresholder thresholder;
	

	//------------ PRIVATE CONSTRUCTOR ------------\\

	private Neuron(double[] weights, NonLinearThresholder thresholder) {
		this.weights = weights;
		this.thresholder = thresholder; 
	}
	

	//------------ PROTECTED STATIC CONSTRUCTORS ------------\\

	protected static Neuron valueOf(double[] weights, NonLinearThresholder thresholder) {
		double[] actualWeights = new double[weights.length];
		
		for (int i = 0; i < weights.length; ++i) {
			actualWeights[i] = weights[i];
		}
		
		return new Neuron(actualWeights, thresholder);
	}
	
	protected static Neuron createRandom(int nbWeights, NonLinearThresholder thresholder) {
		double[] weights = new double[nbWeights];
		
		for (int i = 0; i < nbWeights - 1; ++i) {
			weights[i] = RandNumGen.nextDouble(-INIT_RAND_WEIGHT_RANGE, INIT_RAND_WEIGHT_RANGE);
		}
		weights[nbWeights - 1] = INITIAL_BIAS;
		
		return new Neuron(weights, thresholder);
	}
	

	//------------ PROCESS ------------\\

	public double process(double[] inputs) throws NeuralNetworkException {
		if (inputs.length != getNbEffectiveWeights()) {
			throw new NeuralNetworkException("Input size (" + inputs.length + ") must match the "
					+ "number of weights of the neuron (" + getNbEffectiveWeights() + ").");
		}
		double cumul = 0;
		
		for (int i = 0; i < inputs.length; ++i) {
			cumul += weights[i] * inputs[i];
		}
		
		cumul -= getBias();
		
		return thresholder.apply(cumul);
	}
	
	
	//------------ GETTERS ------------\\

	public double getWeight(int weightIndex) {
		if (weightIndex < 0 || weightIndex >= getNbEffectiveWeights()) {
			throw new IllegalArgumentException("Invalid weight index \"" + weightIndex 
					+ "\": Neuron has " + getNbEffectiveWeights() + " weigths (without bias).");
		}
		return weights[weightIndex];
	}
	
	public double[] getWeights() {
		return weights;
	}

	public double getBias() {
		return weights[getTotalNbWeights() - 1];
	}
	
	public int getNbEffectiveWeights() {
		return getTotalNbWeights() - 1;
	}

	public int getTotalNbWeights() {
		return weights.length;
	}
	
	public NonLinearThresholder getThresholder() {
		return thresholder;
	}
}
