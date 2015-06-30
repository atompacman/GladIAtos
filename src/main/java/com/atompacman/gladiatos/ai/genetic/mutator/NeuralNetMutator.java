package com.atompacman.gladiatos.ai.genetic.mutator;

import com.atompacman.toolkat.math.Norm;
import com.atompacman.toolkat.math.RandNumGen;

public class NeuralNetMutator extends Mutator<Double> {

    //====================================== CONSTANTS ===========================================\\

    private static final Norm   DEFAULT_MUTATION_RATE    = new Norm(0.5);
    private static final double DEFAULT_MAX_PERTURBATION = 0.01;


    
    //======================================= METHODS ============================================\\

    //---------------------------------- PUBLIC CONSTRUCTOR --------------------------------------\\

    public NeuralNetMutator() {
        super(DEFAULT_MUTATION_RATE, DEFAULT_MAX_PERTURBATION);
    }
    
    public NeuralNetMutator(Norm mutationRate, double maxPerturbation) {
        super(mutationRate, maxPerturbation);
    }


    //---------------------------------------- ALTER ---------------------------------------------\\

    protected Double alter(Double element) {
        return element + RandNumGen.nextDouble(-1, 1) * maxPerturbation;
    }
}
