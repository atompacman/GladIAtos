package com.atompacman.gladiatos.ai.genetic.crossover;

import java.util.HashSet;
import java.util.Set;

import com.atompacman.toolkat.math.RandGen;

public class NPointCrossover<T> extends CrossoverMethod<T> {

    //======================================= FIELDS =============================================\\

    private final int n;



    //======================================= METHODS ============================================\\

    //---------------------------------- PUBLIC CONSTRUCTOR --------------------------------------\\

    public NPointCrossover(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The number of crossover points must be positive.");
        }
        this.n = n;
    }


    //-------------------------------------- CROSSOVER -------------------------------------------\\

    protected void crossover(T[] motherDNA, T[] fatherDNA) {
        Set<Integer> crossoverPoints = new HashSet<Integer>();

        if (n < motherDNA.length) {
            int newPoint;
            for (int i = 0; i < n; ++i) {
                do {
                    newPoint = RandGen.nextInt(0, motherDNA.length);
                } while (crossoverPoints.contains(newPoint));
                crossoverPoints.add(newPoint);
            }
        } else {
            for (int i = 0; i < motherDNA.length; ++i) {
                crossoverPoints.add(i);
            }
        }

        boolean exchangeOn = true;
        for (int i = 0; i < motherDNA.length; ++i) {
            if (crossoverPoints.contains(i)) {
                exchangeOn = !exchangeOn;
            }
            if (exchangeOn) {
                T motherElem = motherDNA[i];
                motherDNA[i] = fatherDNA[i];
                fatherDNA[i] = motherElem;
            }
        }
    }
}
