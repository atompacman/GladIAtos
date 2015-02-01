package com.atompacman.gladiatos.ai.genetic.selection;

import com.atompacman.gladiatos.ai.genetic.individual.Individual;
import com.atompacman.gladiatos.ai.genetic.population.Population;

public abstract class SelectionMethod<T> {

	//------------ SELECT INDIVIDUAL ------------\\

	public abstract Individual<T> selectIndividual(Population<T> population);
}
