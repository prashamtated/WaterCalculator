package com.prasham;

import static java.lang.Math.min;

/**
 * @author PRASHAMT
 *
 */
public class WaterCalculator {

	/**
	 * @param landscape
	 * @return units of water collected
	 */
	public static long calculateWaterAmount(final int[] landscape) {

		validateLandscape(landscape);

		if (landscape.length == 0) {
			return 0;
		}

		final int[] leftBorderHeight = new int[landscape.length];
		final int[] rightBorderHeight = new int[landscape.length];

		populateBorderHeights(landscape, leftBorderHeight, rightBorderHeight);

		return doCalculateWaterAmount(landscape, leftBorderHeight, rightBorderHeight);
	}

	/**
	 * @param landscape
	 */
	private static void validateLandscape(final int[] landscape) {

		if (landscape.length > 32000) {
			throw new IllegalArgumentException("Landscape should not contain more than 32000 elements!");
		}

		for (int height : landscape) {

			if (height < 0) {
				throw new IllegalArgumentException("Landscape heights should not be negative!");
			}

			if (height > 32000) {
				throw new IllegalArgumentException("Landscape heights should not be higher than 32000!");
			}
		}
	}

	/**
	 * @param landscape
	 * @param leftBorderHeight
	 * @param rightBorderHeight
	 */
	private static void populateBorderHeights(final int[] landscape, final int[] leftBorderHeight,
			final int[] rightBorderHeight) {

		int currentLeftHeight = landscape[0];
		int currentRightHeight = landscape[landscape.length - 1];

		for (int i = 0; i < landscape.length; i++) {

			if (currentLeftHeight < landscape[i]) {
				leftBorderHeight[i] = landscape[i];
				currentLeftHeight = landscape[i];
			} else {
				leftBorderHeight[i] = currentLeftHeight;
			}

			final int rightIndex = landscape.length - i - 1;

			if (currentRightHeight < landscape[rightIndex]) {
				rightBorderHeight[rightIndex] = landscape[rightIndex];
				currentRightHeight = landscape[rightIndex];
			} else {
				rightBorderHeight[rightIndex] = currentRightHeight;
			}
		}

	}

	/**
	 * @param landscape
	 * @param leftBorderHeight
	 * @param rightBorderHeight
	 * @return units of water collected
	 */
	private static long doCalculateWaterAmount(final int[] landscape, final int[] leftBorderHeight,
			final int[] rightBorderHeight) {
		long amount = 0;
		for (int i = 0; i < landscape.length; i++) {
			amount += min(leftBorderHeight[i], rightBorderHeight[i]) - landscape[i];
		}
		return amount;
	}

}
