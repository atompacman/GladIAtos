package com.atompacman.gladiatos.ai.genetic.crossover;

import com.atompacman.toolkat.math.Norm;

public class UniformCrossover<T> extends CrossoverMethod<T> {

    //====================================== CONSTANTS ===========================================\\

    private static final Norm DEFAULT_CROSSOVER_RATE = new Norm(0.4);



    //======================================= FIELDS =============================================\\

    protected final Norm crossoverRate;



    //======================================= METHODS ============================================\\

    //---------------------------------- PUBLIC CONSTRUCTOR --------------------------------------\\

    public UniformCrossover() {
        this(DEFAULT_CROSSOVER_RATE);
    }

    public UniformCrossover(Norm crossoverRate) {
        this.crossoverRate = crossoverRate;
    }


    //-------------------------------------- CROSSOVER -------------------------------------------\\

    protected void crossover(T[] motherDNA, T[] fatherDNA) {	
        for (int i = 0; i < motherDNA.length; ++i) {
            if (crossoverRate.doUniformRandomTest()) {
                T motherElem = motherDNA[i];
                motherDNA[i] = fatherDNA[i];
                fatherDNA[i] = motherElem;
            }
        }
    }
}
