package com.atompacman.gladiatos.ai.neuralNet;

import java.util.List;

import com.atompacman.toolkat.misc.Collections2;

public abstract class FFNNDescription extends NeuralNetDescription {

	protected final List<Integer> nbNeuronsInLayers;
	protected final List<Integer> nbWeightsInLayers;


	//------------ PROTECTED CONSTRUCTOR ------------\\

	protected FFNNDescription(
			List<Integer> nbNeuronsInLayers, 
			List<Integer> nbWeightsInLayers, 
			int nbInputs,
			NonLinearThresholder thresholder) {
		
		super(
				Collections2.sum(nbNeuronsInLayers), 
				Collections2.sum(nbWeightsInLayers), 
				nbInputs, 
				nbNeuronsInLayers.get(nbNeuronsInLayers.size() - 1),
				thresholder);

		this.nbNeuronsInLayers = nbNeuronsInLayers;
		this.nbWeightsInLayers = nbWeightsInLayers;
	}


	//------------ GETTERS ------------\\

	public int getNbNeuronsInLayer(int layerIndex) {
		if (layerIndex < 0 || layerIndex >= nbNeuronsInLayers.size()) {
			throw new IllegalArgumentException("Invalid layer index \"" + layerIndex + "\": "
					+ "Neural net structure has " + nbNeuronsInLayers.size() + " layers.");
		}
		return nbNeuronsInLayers.get(layerIndex);
	}

	public int getNbWeightsInLayer(int layerIndex) {
		if (layerIndex < 0 || layerIndex >= nbWeightsInLayers.size()) {
			throw new IllegalArgumentException("Invalid layer index \"" + layerIndex + "\": "
					+ "Neural net structure has " + nbNeuronsInLayers.size() + " layers.");
		}
		return nbWeightsInLayers.get(layerIndex);
	}

	public int getNbHiddenLayers() {
		return nbNeuronsInLayers.size();
	}
}
