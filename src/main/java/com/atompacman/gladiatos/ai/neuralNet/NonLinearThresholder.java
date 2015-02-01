package com.atompacman.gladiatos.ai.neuralNet;

public enum NonLinearThresholder {

	SIGMOID {
		public double apply(double input) {
			return 1 / (1 + Math.exp(-input * SIGMOID_ACTIVATION_RESPONSE_WIDTH_INVERSE));
		}
	},
	
	TANH {
		public double apply(double input) {
			double eX = Math.exp(input);
			double eNegX = Math.exp(-input);
			return (eX - eNegX) / (eX + eNegX);
		}
	};
	
	private static double SIGMOID_ACTIVATION_RESPONSE_WIDTH_INVERSE = 1;
	

	//------------ APPLY ------------\\

	public abstract double apply(double input);
}
