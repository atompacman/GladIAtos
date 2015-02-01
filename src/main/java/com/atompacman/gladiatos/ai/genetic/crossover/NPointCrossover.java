package com.atompacman.gladiatos.ai.genetic.crossover;

import java.util.HashSet;
import java.util.Set;

import com.atompacman.gladiatos.ai.util.RandNumGen;

public class NPointCrossover<T> extends CrossoverMethod<T> {

	private int n;
	
	
	//------------ CONSTRUCTOR ------------\\

	public NPointCrossover(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("The number of crossover points cannot be null.");
		}
		this.n = n;
	}
	
	
	//------------ GENERATE OFFSPRING ------------\\

	protected void crossover(T[] motherDNA, T[] fatherDNA) {
		if (n > motherDNA.length) {
			throw new IllegalArgumentException("The number of crossover "
					+ "points cannot be higher than the size of the DNA.");

		}
		Set<Integer> crossoverPoints = new HashSet<Integer>();
		
		int newPoint;
		for (int i = 0; i < n; ++i) {
			do {
				newPoint = (int) RandNumGen.nextDouble(0, motherDNA.length);
			} while(crossoverPoints.contains(newPoint));
			crossoverPoints.add(newPoint);
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
