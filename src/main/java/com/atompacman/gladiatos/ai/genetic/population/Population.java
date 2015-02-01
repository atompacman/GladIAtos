package com.atompacman.gladiatos.ai.genetic.population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.atompacman.gladiatos.ai.genetic.individual.Individual;

public class Population<T> {

	protected List<Individual<T>> individuals;

	protected double worstFitness;
	protected double averageFitness;
	protected double bestFitness;
	protected double fitnessStdDev;
	protected double totalFitness;

	
	//------------ CONSTRUCTOR ------------\\

	public Population() {
		this.individuals = new ArrayList<Individual<T>>();
		resetFitnessStats();
	}
	
	
	//------------ COMPUTE FITNESS STATS ------------\\

	public void updateFitnessStats() {
		resetFitnessStats();

		for (int i = 0; i < size(); ++i) {
			double fitness = getIndividual(i).getFitness();
			totalFitness += fitness;
			
			if (fitness < getWorstFitness()) {
				worstFitness = fitness;
			}
			if (fitness > getBestFitness()) {
				bestFitness = fitness;
			}
		}
		
		averageFitness = getTotalFitness() / size();
		
		for (int i = 0; i < size(); ++i) {
			double fitness = getIndividual(i).getFitness();
			double deviation = fitness - getAverageFitness();
			fitnessStdDev += + deviation * deviation;
		}
		fitnessStdDev = Math.sqrt(fitnessStdDev);
	}
		
	
	//------------ SORT BY FITNESS ------------\\

	public void sortByFitness() {
		Collections.sort(individuals);
	}
	
	
	//------------ GETTERS ------------\\

	public Individual<T> getIndividual(int individualIndex) {
		checkIndividualIndex(individualIndex);
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
	
	
	//------------ SETTERS ------------\\

	public void resetFitnessStats() {
		worstFitness = Double.MAX_VALUE;
		averageFitness = 0;
		bestFitness = -Double.MAX_VALUE;
		fitnessStdDev = 0;
		totalFitness = 0;
	}


	//------------ PRIVATE UTILS ------------\\

	protected void checkIndividualIndex(int individualIndex) {
		if (individualIndex < 0 || individualIndex >= size()) {
			throw new IllegalArgumentException("Invalid individual index \"" + individualIndex 
					+ "\": Population has " + size() + " individuals.");
		}
	}


}
