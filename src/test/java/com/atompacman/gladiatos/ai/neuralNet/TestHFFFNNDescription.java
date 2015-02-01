package com.atompacman.gladiatos.ai.neuralNet;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestHFFFNNDescription {

	//------------ STATIC CONSTRUCTOR ------------\\

	@Test
	public void case1() {
		int nbInputs = 3;
		List<Integer> nbNeuronsInLayers = Arrays.asList(3, 4);
		HFFFNNDescription desc = HFFFNNDescription.specifiedBy(nbNeuronsInLayers, nbInputs);
		
		assertEquals(2,  desc.getNbHiddenLayers());
		assertEquals(3,  desc.getNbInputs());
		assertEquals(3,  desc.getNbNeuronsInLayer(0));
		assertEquals(4,  desc.getNbNeuronsInLayer(1));
		assertEquals(4,  desc.getNbOutputs());
		assertEquals(12, desc.getNbWeightsInLayer(0));
		assertEquals(16, desc.getNbWeightsInLayer(1));
		assertEquals(4,  desc.getNbWeightsInNeuronsOfLayer(0));
		assertEquals(4,  desc.getNbWeightsInNeuronsOfLayer(1));
		assertEquals(NNParameters.DEFAULT_THRESHOLDER, desc.getThresholder());
		assertEquals(7,  desc.getTotalNbNeurons());
		assertEquals(28, desc.getTotalNbWeigths());
	}
	
	@Test
	public void case2() {
		int nbInputs = 1;
		List<Integer> nbNeuronsInLayers = Arrays.asList(1);
		HFFFNNDescription desc = HFFFNNDescription.specifiedBy(nbNeuronsInLayers, nbInputs);
		
		assertEquals(1,  desc.getNbHiddenLayers());
		assertEquals(1,  desc.getNbInputs());
		assertEquals(1,  desc.getNbNeuronsInLayer(0));
		assertEquals(1,  desc.getNbOutputs());
		assertEquals(2,  desc.getNbWeightsInLayer(0));
		assertEquals(2,  desc.getNbWeightsInNeuronsOfLayer(0));
		assertEquals(NNParameters.DEFAULT_THRESHOLDER, desc.getThresholder());
		assertEquals(1,  desc.getTotalNbNeurons());
		assertEquals(2, desc.getTotalNbWeigths());
	}
	
	@Test
	public void case3() {
		int nbInputs = 0;
		List<Integer> nbNeuronsInLayers = Arrays.asList(0);
		HFFFNNDescription desc = HFFFNNDescription.specifiedBy(nbNeuronsInLayers, nbInputs);
		
		assertEquals(1,  desc.getNbHiddenLayers());
		assertEquals(0,  desc.getNbInputs());
		assertEquals(0,  desc.getNbNeuronsInLayer(0));
		assertEquals(0,  desc.getNbOutputs());
		assertEquals(0,  desc.getNbWeightsInLayer(0));
		assertEquals(0,  desc.getNbWeightsInNeuronsOfLayer(0));
		assertEquals(NNParameters.DEFAULT_THRESHOLDER, desc.getThresholder());
		assertEquals(0,  desc.getTotalNbNeurons());
		assertEquals(0, desc.getTotalNbWeigths());
	}
}
