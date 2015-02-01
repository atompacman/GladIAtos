package com.atompacman.gladiatos.ai.neuralNet;

public class NeuralNetworkException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	public NeuralNetworkException() { 
		super(); 
	}

	public NeuralNetworkException(String message) {
		super(message); 
	}

	public NeuralNetworkException(String message, Throwable cause) {
		super(message, cause); 
	}

	public NeuralNetworkException(Throwable cause) { 
		super(cause); 
	}
}
