package com.atompacman.gladiatos.ai.genetic.mutator;

import com.atompacman.gladiatos.ai.util.RandNumGen;

public class NeuralNetMutator extends Mutator<Double> {
	
	private static final double DEFAULT_MUTATION_RATE  = 0.5;
	private static final double DEFAULT_MAX_PERTURBATION = 0.01;
		
	
	//------------ PRIVATE CONSTRUCTORS ------------\\
	
	private NeuralNetMutator(double mutationRate, double maxPerturbation) {
		super(mutationRate, maxPerturbation);
	}
	
	
	//------------ STATIC CONSTRUCTORS ------------\\
	
	public static NeuralNetMutator createDefault() {
		return new NeuralNetMutator(DEFAULT_MUTATION_RATE, DEFAULT_MAX_PERTURBATION);
	}
	
	public static NeuralNetMutator valueOf(double mutationRate, double maxPerturbation) {
		return new NeuralNetMutator(mutationRate, maxPerturbation);
	}
	
	
	//------------ ALTER ELEMENT ------------\\

	protected Double alterElement(Double element) {
		return element + RandNumGen.nextDouble(-1, 1) * maxPerturbation;
	}
}
