package com.atompacman.gladiatos.ai.genetic.population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.atompacman.gladiatos.ai.genetic.individual.Individual;

public class Population<T> {

    //======================================= FIELDS =============================================\\

    protected List<Individual<T>> individuals;

    protected double worstFitness;
    protected double averageFitness;
    protected double bestFitness;
    protected double fitnessStdDev;
    protected double totalFitness;



    //======================================= METHODS ============================================\\

    //---------------------------------- PUBLIC CONSTRUCTOR --------------------------------------\\

    public Population() {
        this.individuals = new ArrayList<Individual<T>>();
        resetFitnessStats();
    }


    //-------------------------------- COMPUTE FITNESS STATS -------------------------------------\\

    public void updateFitnessStats() {
        resetFitnessStats();

        for (Individual<T> individual : individuals) {
            double fitness = individual.getFitness();
            totalFitness += fitness;

            if (fitness < worstFitness) {
                worstFitness = fitness;
            }
            if (fitness > bestFitness) {
                bestFitness = fitness;
            }
        }

        averageFitness = totalFitness / individuals.size();

        for (Individual<T> individual : individuals) {
            double deviation = individual.getFitness() - averageFitness;
            fitnessStdDev += deviation * deviation;
        }
        fitnessStdDev = Math.sqrt(fitnessStdDev);
    }


    //----------------------------------- SORT BY FITNESS ----------------------------------------\\

    public void sortByFitness() {
        Collections.sort(individuals);
    }


    //--------------------------------------- GETTERS --------------------------------------------\\

    public Individual<T> getIndividual(int individualIndex) {
        if (individualIndex < 0 || individualIndex >= size()) {
            throw new IllegalArgumentException("Invalid individual index \"" + individualIndex 
                    + "\": Population has " + size() + " individuals.");
        }
        return individuals.get(individualIndex);
    }

    public int size() {
        return individuals.size();
    }

    public double getWorstFitness() {
        return worstFitness;
    }

    public double getAverageFitness() {
        return averageFitness;
    }

    public double getBestFitness() {
        return bestFitness;
    }

    public double getFitnessStdDev() {
        return fitnessStdDev;
    }

    public double getTotalFitness() {
        return totalFitness;
    }


    //--------------------------------------- SETTERS --------------------------------------------\\

    public void resetFitnessStats() {
        worstFitness    = Double.MAX_VALUE;
        averageFitness  = 0;
        bestFitness     = -Double.MAX_VALUE;
        fitnessStdDev   = 0;
        totalFitness    = 0;
    }
}
