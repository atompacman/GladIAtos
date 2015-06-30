package com.atompacman.gladiatos.ai.genetic.crossover;

import com.atompacman.gladiatos.ai.genetic.GeneticAlgorithmException;
import com.atompacman.gladiatos.ai.genetic.individual.Individual;
import com.atompacman.toolkat.exception.Throw;

public abstract class CrossoverMethod<T> {

    //=================================== ABSTRACT METHODS =======================================\\

    //-------------------------------------- CROSSOVER -------------------------------------------\\

    protected abstract void crossover(T[] motherDNA, T[] fatherDNA);



    //======================================= METHODS ============================================\\

    //-------------------------------------- CROSSOVER -------------------------------------------\\

    public final void crossover(Individual<T> mother, Individual<T> father) 
                                                    throws GeneticAlgorithmException {
        T[] motherDNA = mother.getGenome().getDNA();
        T[] fatherDNA = father.getGenome().getDNA();

        if (motherDNA.length != fatherDNA.length) {
            Throw.a(GeneticAlgorithmException.class, "Mother DNA size (" + motherDNA.length 
                    + ") must match father DNA size (" + fatherDNA.length + ").");
        }
        crossover(motherDNA, fatherDNA);
    }
}
