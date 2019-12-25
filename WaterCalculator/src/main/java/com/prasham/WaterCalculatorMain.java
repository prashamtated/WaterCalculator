package com.prasham;

import static com.prasham.WaterCalculator.calculateWaterAmount;

/**
 * @author PRASHAMT
 *
 */
public class WaterCalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Check input argument
		if (args.length < 1) {
			throw new IllegalArgumentException("Please supply landscape as a program argument");
		}

		// Convert string type argument integer argument for further calculations
		final int[] landscape = new int[args.length];
		for (int i = 0; i < args.length; i++) {
			landscape[i] = Integer.parseInt(args[i]);
		}

		final long waterAmount = calculateWaterAmount(landscape);

		System.out.println("Water collected inside pits is " + waterAmount + " units");
	}

}
