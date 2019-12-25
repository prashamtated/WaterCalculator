package com.prasham;

import static com.prasham.WaterCalculatorMain.main;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author PRASHAMT
 *
 */
class WaterCalculatorMainTest {

	@Test
	void check_input_to_program_null() {

		final String[] landscape = {};
		assertThrows(IllegalArgumentException.class, () -> main(landscape));
	}

}
