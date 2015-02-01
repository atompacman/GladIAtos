package com.atompacman.gladiatos.ai.neuralNet;

import java.util.ArrayList;
import java.util.List;

public final class HFFFNNDescription extends FFNNDescription {
	
	private final List<Integer> nbWeightsInNeuronsOfLayer;

	
	//------------ PRIVATE CONSTRUCTOR ------------\\

	private HFFFNNDescription(
			List<Integer> nbNeuronsInLayers, 
			int nbInputs, 
			NonLinearThresholder thresholder) {
		
		super(
				nbNeuronsInLayers, 
				countWeightsInLayers(nbNeuronsInLayers, nbInputs), 
				nbInputs,
				thresholder);

		nbWeightsInNeuronsOfLayer = new ArrayList<Integer>();
		nbWeightsInNeuronsOfLayer.add(nbInputs);

		if (getNbHiddenLayers() > 0 && nbNeuronsInLayers.get(0) != 0) {
			nbWeightsInNeuronsOfLayer.set(0, nbInputs + 1);
		}
		
		for (int i = 1; i < nbNeuronsInLayers.size(); ++i) {
			nbWeightsInNeuronsOfLayer.add(nbNeuronsInLayers.get(i - 1) + 1);
		}
	}
	
	private static List<Integer> countWeightsInLayers(
			List<Integer> nbNeuronsInLayers, 
			int nbInputs) {
		
		List<Integer> nbWeightsInLayers = new ArrayList<Integer>();
		int precedent = nbInputs;
		
		for (int i = 0; i < nbNeuronsInLayers.size(); ++i) {
			nbWeightsInLayers.add((precedent + 1) * nbNeuronsInLayers.get(i));
			precedent = nbNeuronsInLayers.get(i);
		}
		
		return nbWeightsInLayers;
	}
	
	
	//------------ STATIC CONSTRUCTORS ------------\\

	public static HFFFNNDescription specifiedBy(
			List<Integer> nbNeuronsInLayers, 
			int nbInputs) {
		
		return new HFFFNNDescription(nbNeuronsInLayers, nbInputs, NNParameters.DEFAULT_THRESHOLDER);
	}
	
	public static HFFFNNDescription specifiedBy(
			List<Integer> nbNeuronsInLayers, 
			int nbInputs, 
			NonLinearThresholder thresholder) {
		
		return new HFFFNNDescription(nbNeuronsInLayers, nbInputs, thresholder);
	}
	
	
	//------------ GETTERS ------------\\
	
	public int getNbWeightsInNeuronsOfLayer(int layerIndex) {
		if (layerIndex < 0 || layerIndex >= nbWeightsInNeuronsOfLayer.size()) {
			throw new IllegalArgumentException("Invalid layer index \"" + layerIndex + "\": "
					+ "Neural net structure has " + nbWeightsInNeuronsOfLayer.size() + " layers.");
		}
		return nbWeightsInNeuronsOfLayer.get(layerIndex);
	}
}
