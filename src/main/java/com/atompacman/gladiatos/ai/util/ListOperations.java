package com.atompacman.gladiatos.ai.util;

import java.util.List;

public class ListOperations {

	public static int cumulativeSum(List<Integer> vector) {
		int sum = 0;
		for (int component : vector) {
			sum += component;
		}
		return sum;
	}
}
