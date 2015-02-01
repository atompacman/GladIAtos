package com.atompacman.gladiatos.ai.genetic.manager;

import com.atompacman.gladiatos.ai.genetic.crossover.CrossoverMethod;
import com.atompacman.gladiatos.ai.genetic.mutator.Mutator;
import com.atompacman.gladiatos.ai.genetic.population.Population;
import com.atompacman.gladiatos.ai.genetic.selection.SelectionMethod;

public abstract class GeneticManager<T> {

	protected Population<T> population;
	protected CrossoverMethod<T> crossoverMethod;
	protected Mutator<T> mutator;
	protected SelectionMethod<T> selectionMethod;
	
	//private List<Integer> eliteCopies;
	
	
	//------------ PROCESS EPOCH ------------\\

	public void processEpoch() {
		// EVALUATE FITNESS
		population.sortByFitness();
		
		
		
		population.updateFitnessStats();
		
	}
}
