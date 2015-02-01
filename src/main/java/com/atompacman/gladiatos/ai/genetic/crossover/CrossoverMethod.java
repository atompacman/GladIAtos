package com.atompacman.gladiatos.ai.genetic.crossover;

import com.atompacman.gladiatos.ai.genetic.GeneticAlgorithmException;
import com.atompacman.gladiatos.ai.genetic.individual.Individual;

public abstract class CrossoverMethod<T> {
	
	private static final double DEFAULT_CROSSOVER_RATE = 0.4;

	
	protected final double crossoverRate;

	
	//------------ CONSTRUCTOR ------------\\

	public CrossoverMethod() {
		this(DEFAULT_CROSSOVER_RATE);
	}
	
	public CrossoverMethod(double crossoverRate) {
		this.crossoverRate = crossoverRate;
	}
	
	
	//------------ CROSSOVER ------------\\

	public void crossover(Individual<T> mother, Individual<T> father) 
			throws GeneticAlgorithmException {
		T[] motherDNA = mother.getGenome().getDNA();
		T[] fatherDNA = father.getGenome().getDNA();

		if (motherDNA.length != fatherDNA.length) {
			throw new GeneticAlgorithmException("Mother DNA size (" + motherDNA.length 
					+ ") must match father DNA size (" + fatherDNA.length + ").");
		}
		
		crossover(motherDNA, fatherDNA);
	}
	
	protected abstract void crossover(T[] motherDNA, T[] fatherDNA);
}
