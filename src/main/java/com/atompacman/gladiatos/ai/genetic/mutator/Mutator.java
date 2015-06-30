package com.atompacman.gladiatos.ai.genetic.mutator;

import java.util.List;

import com.atompacman.toolkat.math.Norm;

public abstract class Mutator<T> {

    //======================================= FIELDS =============================================\\

    private   final Norm mutationRate;
    protected final T    maxPerturbation;


    
    //=================================== ABSTRACT METHODS =======================================\\

    //---------------------------------------- ALTER ---------------------------------------------\\
    
    protected abstract T alter(T element);

    
    
    //======================================= METHODS ============================================\\

    //---------------------------------- PUBLIC CONSTRUCTOR --------------------------------------\\

    public Mutator(Norm mutationRate, T maxPerturbation) {
        this.mutationRate    = mutationRate;
        this.maxPerturbation = maxPerturbation;
    }


    //--------------------------------------- MUTATE ---------------------------------------------\\

    public void mutate(List<T> dna) {
        for (T element : dna) {
            if (mutationRate.doUniformRandomTest()) {
                alter(element);
            }
        }
    }
}
