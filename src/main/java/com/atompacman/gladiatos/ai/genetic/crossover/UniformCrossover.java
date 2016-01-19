package com.atompacman.gladiatos.ai.genetic.crossover;

import com.atompacman.toolkat.math.RandGen;
import com.atompacman.toolkat.math.UNorm;

public class UniformCrossover<T> extends CrossoverMethod<T> {

    //====================================== CONSTANTS ===========================================\\

    private static final UNorm DEFAULT_CROSSOVER_RATE = new UNorm(0.4);



    //======================================= FIELDS =============================================\\

    protected final UNorm crossoverRate;



    //======================================= METHODS ============================================\\

    //---------------------------------- PUBLIC CONSTRUCTOR --------------------------------------\\

    public UniformCrossover() {
        this(DEFAULT_CROSSOVER_RATE);
    }

    public UniformCrossover(UNorm crossoverRate) {
        this.crossoverRate = crossoverRate;
    }


    //-------------------------------------- CROSSOVER -------------------------------------------\\

    protected void crossover(T[] motherDNA, T[] fatherDNA) {	
        for (int i = 0; i < motherDNA.length; ++i) {
            if (crossoverRate.v() < RandGen.nextDouble(0.0, 1.0)){
                T motherElem = motherDNA[i];
                motherDNA[i] = fatherDNA[i];
                fatherDNA[i] = motherElem;
            }
        }
    }
}
