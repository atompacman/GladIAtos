package com.atompacman.gladiatos.ai.genetic.selection;

import com.atompacman.gladiatos.ai.genetic.individual.Individual;
import com.atompacman.gladiatos.ai.genetic.population.Population;
import com.atompacman.toolkat.math.RandGen;

public class Roulette<T> extends SelectionMethod<T> {

    //--------------------------------------- SELECT ---------------------------------------------\\

    public Individual<T> select(Population<T> population) {
        double slice = RandGen.nextDouble(0, 1) * population.getTotalFitness();
        double cumul = 0;

        for (int i = 0; i < population.size(); ++i) {
            Individual<T> individual = population.getIndividual(i);
            cumul += individual.getFitness();

            if (cumul > slice) {
                return individual;
            }
        }
        throw new RuntimeException("Roulette didn't work...");
    }
}
