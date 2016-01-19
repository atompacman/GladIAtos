package com.atompacman.gladiatos.ai.genetic.mutator;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.atompacman.toolkat.math.UNorm;

public class TestNeuralNetMutator {

	@Test
	public void testNeuralNetMutator() {
		double[] dna = {1.42, 1.6, 0.52, 1.42, 1.6, 0.52};

		List<Double> altered = new ArrayList<Double>();
		
		for (double value : dna) {
			altered.add(value);
		}
		
		Mutator<Double> mutator = new NeuralNetMutator(new UNorm(1.0), 0.01);
		mutator.mutate(altered);
		
		for (int i = 0; i < dna.length; ++i) {
			assertTrue(dna[i] != altered.get(i));
		}
	}
}
