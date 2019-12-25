package com.prasham;

import static org.junit.jupiter.api.Assertions.*;
import static com.prasham.WaterCalculator.calculateWaterAmount;
import static java.util.stream.IntStream.generate;

import org.junit.jupiter.api.Test;

/**
 * @author PRASHAMT
 * This class for testing calculateWaterAmount method from com.prasham.WaterCalculator class
 */
class WaterCalculatorTest {

	@Test
    void calculateWater_whenBothBorderHeighted() {
        final int[] landscape = {6, 2, 3, 5, 0, 5};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(10, waterAmount);
    }

    @Test
    void calculateWater_whenLeftBorderHeighted() {
        final int[] landscape = {5, 2, 3, 4, 5, 4, 0, 3, 1};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(9, waterAmount);
    }

    @Test
    void calculateWater_whenRightBorderHeighted() {
        final int[] landscape = {1, 3, 0, 4, 5, 4, 3, 2, 5};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(9, waterAmount);
    }

    @Test
    void returnZero_when_landscape_is_of_length_one() {
        final int[] landscape = {5};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    void returnZero_when_landscape_is_of_length_zero() {
        final int[] landscape = {};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    void throwException_when_landscape_contains_negative_height() {
        final int[] landscape = {3, -2, 0};

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

    @Test
    void throwException_when_landscape_contains_height_bigger_than_32000() {
        final int[] landscape = {3, 2, 32001, 700};

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

    @Test
    void throwException_when_landscape_contains_more_than_32000_elements() {
        final int[] landscape = new int[32001];

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

    @Test
    void returnZero_when_landscape_is_of_zeros() {
        final int[] landscape = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    void returnZero_when_landscape_is_of_max_length_but_flat() {
        final int[] landscape = generate(() -> 32000).limit(32000).toArray();

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    void returnZero_when_landscape_is_a_pyramid() {
        final int[] landscape = {0, 1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1};

        final long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

}
