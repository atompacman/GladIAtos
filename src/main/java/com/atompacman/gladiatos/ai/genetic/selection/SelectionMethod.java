package com.atompacman.gladiatos.ai.genetic.selection;

import com.atompacman.gladiatos.ai.genetic.individual.Individual;
import com.atompacman.gladiatos.ai.genetic.population.Population;

public abstract class SelectionMethod<T> {

    //=================================== ABSTRACT METHODS =======================================\\

    //--------------------------------------- SELECT ---------------------------------------------\\

    public abstract Individual<T> select(Population<T> population);
}
