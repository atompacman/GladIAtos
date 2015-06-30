package com.atompacman.gladiatos.ai.genetic.individual;

import com.atompacman.gladiatos.ai.genetic.genome.Genome;

public abstract class Individual<T> implements Comparable<Individual<T>> {

    //======================================= FIELDS =============================================\\

    protected Genome<T> genome;
    protected double fitness;



    //======================================= METHODS ============================================\\

    //---------------------------------- PUBLIC CONSTRUCTOR --------------------------------------\\

    public Individual(Genome<T> genome) {
        this.genome = genome;
        this.fitness = 0;
    }


    //--------------------------------------- GETTERS --------------------------------------------\\

    public Genome<T> getGenome() {
        return genome;
    }

    public double getFitness() {
        return fitness;
    }


    //------------------------------------- COMPARE TO -------------------------------------------\\

    public int compareTo(Individual<T> individual) {
        return Double.compare(fitness, individual.fitness);
    }
}
