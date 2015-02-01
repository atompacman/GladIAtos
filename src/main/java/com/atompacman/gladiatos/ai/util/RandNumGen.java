package com.atompacman.gladiatos.ai.util;

import java.util.Random;

public class RandNumGen {

	private static final long RANDOM_SEED = 23532523;
	
	
	private static Random randGen;
	
	
	
	//------------ STATIC INITIALIZATION ------------\\

	static {
		randGen = new Random(RANDOM_SEED);
	}
	
	
	//------------ NEXT ------------\\

	public static double nextDouble(double min, double max) {
		return min + randGen.nextDouble() * max;
	}
}
