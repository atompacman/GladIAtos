package com.atompacman.gladiatos.ai.genetic.mutator;

import com.atompacman.toolkat.math.UNorm;
import com.atompacman.toolkat.math.RandGen;

public class NeuralNetMutator extends Mutator<Double> {

    //====================================== CONSTANTS ===========================================\\

    private static final UNorm   DEFAULT_MUTATION_RATE    = new UNorm(0.5);
    private static final double DEFAULT_MAX_PERTURBATION = 0.01;


    
    //======================================= METHODS ============================================\\

    //---------------------------------- PUBLIC CONSTRUCTOR --------------------------------------\\

    public NeuralNetMutator() {
        super(DEFAULT_MUTATION_RATE, DEFAULT_MAX_PERTURBATION);
    }
    
    public NeuralNetMutator(UNorm mutationRate, double maxPerturbation) {
        super(mutationRate, maxPerturbation);
    }


    //---------------------------------------- ALTER ---------------------------------------------\\

    protected Double alter(Double element) {
        return element + RandGen.nextDouble(-1, 1) * maxPerturbation;
    }
}
