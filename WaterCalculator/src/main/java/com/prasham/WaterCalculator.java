package com.prasham;

import static java.lang.Math.min;

/**
 * @author PRASHAMT
 *
 */
public class WaterCalculator {

	private int[] landscape;

	final private int[] leftBorderHeight;
	final private int[] rightBorderHeight;

	public WaterCalculator(int[] landscape) {
		super();
		this.landscape = landscape;
		leftBorderHeight = new int[landscape.length];
		rightBorderHeight = new int[landscape.length];
	}

	/**
	 * @param landscape
	 * @return units of water collected
	 */
	public long calculateWaterAmount() {

		if (landscape.length == 0) {
			return 0;
		}

		if (validateLandscape(landscape)) {
			
			populateBorderHeights(landscape, leftBorderHeight, rightBorderHeight);

			return doCalculateWaterAmount(landscape, leftBorderHeight, rightBorderHeight);
		}

		return 0;
	}

	/**
	 * @param landscape
	 */
	private boolean validateLandscape(final int[] landscape) {

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
		return true;
	}

	/**
	 * @param landscape
	 * @param leftBorderHeight
	 * @param rightBorderHeight
	 */
	private void populateBorderHeights(int[] landscape, int[] leftBorderHeight, int[] rightBorderHeight) {

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
	private long doCalculateWaterAmount(int[] landscape, int[] leftBorderHeight, int[] rightBorderHeight) {
		long amount = 0;
		for (int i = 0; i < landscape.length; i++) {
			amount += min(leftBorderHeight[i], rightBorderHeight[i]) - landscape[i];
		}
		return amount;
	}

}
