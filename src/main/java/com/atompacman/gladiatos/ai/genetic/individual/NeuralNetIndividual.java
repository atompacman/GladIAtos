package com.atompacman.gladiatos.ai.genetic.individual;

import com.atompacman.gladiatos.ai.genetic.genome.NeuralNetGenome;
import com.atompacman.gladiatos.ai.neuralNet.NeuralNet;

public class NeuralNetIndividual extends Individual<Double> {

	//------------ CONSTRUCTOR ------------\\

	public NeuralNetIndividual(NeuralNet neuralNet) {
		super(new NeuralNetGenome(neuralNet));
	}
}
