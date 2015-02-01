package com.atompacman.gladiatos.ai.genetic.genome;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.atompacman.gladiatos.ai.neuralNet.HFFFNeuralNet;
import com.atompacman.gladiatos.ai.neuralNet.NNParameters;
import com.atompacman.gladiatos.ai.neuralNet.NeuralNetworkException;
import com.atompacman.gladiatos.ai.neuralNet.TestHFFFNeuralNet;

public class TestNeuralNetGenome {

	@Test
	public void testNeuralNetGenome() throws NeuralNetworkException {
		double[][][] weights = 
			{{{ 0.5, 0.2,  0.4,  0.3},
				{-0.1, 0.2,  0.4,  0.3},
				{ 0.7, 0.25, 0.2,  0.5},
				{-0.5, 0.2,  0.05, 0.5}}, 

				{{ 0.25, 0.2, 0.1,  0.3},
				{-0.1, -0.2, 0.4, -0.3},
				{ 0.7,  0.8, 0.2,  0.5},
				{-0.5,  0.2, 0.7,  0.5}}};
		
		HFFFNeuralNet net = TestHFFFNeuralNet.buildTestNet(weights, 4);
		
		Genome<Double> genome = new NeuralNetGenome(net);
		
		Double[] dna = genome.getDNA();
		
		assertEquals(0.2, dna[6], NNParameters.EPSILON);
		assertEquals(-0.3, dna[28], NNParameters.EPSILON);
	}
}
