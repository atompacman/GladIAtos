package com.atompacman.gladiatos.ai.genetic.crossover;

import com.atompacman.gladiatos.ai.util.RandNumGen;

public class UniformCrossover<T> extends CrossoverMethod<T> {

	//------------ GENERATE OFFSPRING ------------\\

	protected void crossover(T[] motherDNA, T[] fatherDNA) {	
		for (int i = 0; i < motherDNA.length; ++i) {
			if (RandNumGen.nextDouble(0, 1) < crossoverRate) {
				T motherElem = motherDNA[i];
				motherDNA[i] = fatherDNA[i];
				fatherDNA[i] = motherElem;
			}
		}
	}
}
