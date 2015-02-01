package com.atompacman.gladiatos.ai.genetic;

public class GeneticAlgorithmException extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	public GeneticAlgorithmException() { 
		super(); 
	}

	public GeneticAlgorithmException(String message) {
		super(message); 
	}

	public GeneticAlgorithmException(String message, Throwable cause) {
		super(message, cause); 
	}

	public GeneticAlgorithmException(Throwable cause) { 
		super(cause); 
	}
}
