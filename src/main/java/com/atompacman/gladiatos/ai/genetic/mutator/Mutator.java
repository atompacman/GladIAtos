package com.atompacman.gladiatos.ai.genetic.mutator;

import java.util.List;

import com.atompacman.gladiatos.ai.util.RandNumGen;

public abstract class Mutator<T> {

	private final double mutationRate;
	protected final T maxPerturbation;
	
	
	//------------ CONSTRUCTOR ------------\\
	
	public Mutator(double mutationRate, T maxPerturbation) {
		this.mutationRate = mutationRate;
		this.maxPerturbation = maxPerturbation;
	}
	
	
	//------------ MUTATE ------------\\

	public void mutate(List<T> dna) {
		for (T element : dna) {
			if (RandNumGen.nextDouble(0, 1) < mutationRate) {
				alterElement(element);
			}
		}
	}
	
	
	//------------ ALTER ELEMENT ------------\\

	protected abstract T alterElement(T element);
}
