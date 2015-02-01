package com.atompacman.gladiatos.ai.neuralNet;

public abstract class NeuralNetDescription {

	protected final int nbNeurons;
	protected final int nbWeights;
	protected final int nbInputs;
	protected final int nbOutputs;
	protected final NonLinearThresholder thresholder;
	
	
	//------------ PROTECTED CONSTRUCTOR ------------\\

	protected NeuralNetDescription(
			int nbNeurons, 
			int nbWeights, 
			int nbInputs, 
			int nbOutputs, 
			NonLinearThresholder thresholder) {
		
		this.nbNeurons = nbNeurons;
		this.nbWeights = nbWeights;
		this.nbInputs = nbInputs;
		this.nbOutputs = nbOutputs;
		this.thresholder = thresholder;
	}


	//------------ GETTERS ------------\\

	public int getTotalNbNeurons() {
		return nbNeurons;
	}
	
	public int getTotalNbWeigths() {
		return nbWeights;
	}
	
	public int getNbInputs() {
		return nbInputs;
	}
		
	public int getNbOutputs() {
		return nbOutputs;
	}

	public NonLinearThresholder getThresholder() {
		return thresholder;
	}
}
