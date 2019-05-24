package com.quinn.tacoloco;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.quinn.tacoloco.model.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TacolocoApplicationTests {

	@Autowired
	private TacoLocoService tacoLocoService;

	// Testing an order with three vegetable tacos.
	@Test
	public void allVegetableNoDiscount() {
		// Find vegetable taco price using latest data from API.
		Double vegetableTacoPrice = tacoLocoService.findTacoPrice(0);
		Double actualGrandTotal = (3 * vegetableTacoPrice);
		Double expectedGrandTotal = 7.5;

		assertEquals(expectedGrandTotal, actualGrandTotal);

	}

	// Testing an order with three beef tacos.
	@Test
	public void allBeefNoDiscount() {
		// Find beef taco price using latest data from API.
		Double beefTacoPrice = tacoLocoService.findTacoPrice(2);
		// Calculate actual grand total using price data from API retrieved above.
		Double actualGrandTotal = (3 * beefTacoPrice);

		Double expectedGrandTotal = 9.0;
		// Use same rounding functionality used in controller.
		actualGrandTotal = Math.round(actualGrandTotal * 100.00) / 100.00;

		assertEquals(expectedGrandTotal, actualGrandTotal);

	}

	// Testing an order with 3 different types of tacos.
	@Test
	public void mixedOrderNoDiscount() {
		// Find taco prices using latest data from API.
		Double chickenTacoPrice = tacoLocoService.findTacoPrice(1);
		Double beefTacoPrice = tacoLocoService.findTacoPrice(2);
		Double chorizoTacoPrice = tacoLocoService.findTacoPrice(3);

		// Calculate actual grand total using price data from API retrieved above.
		Double actualGrandTotal = chickenTacoPrice + beefTacoPrice + chorizoTacoPrice;

		// Use same rounding functionality used in controller.
		actualGrandTotal = Math.round(actualGrandTotal * 100.00) / 100.00;

		Double expectedGrandTotal = 9.5;
		assertEquals(expectedGrandTotal, actualGrandTotal);

	}

	// Testing an order with 4 different types of tacos (and discount applied).
	@Test
	public void mixedOrderWithDiscount() {
		// Find taco prices using latest data from API.
		Double chickenTacoPrice = tacoLocoService.findTacoPrice(1);
		Double beefTacoPrice = tacoLocoService.findTacoPrice(2);
		Double chorizoTacoPrice = tacoLocoService.findTacoPrice(3);
		Double vegetableTacoPrice = tacoLocoService.findTacoPrice(0);

		// Calculate actual grand total (with discount) using price data from API
		// retrieved above.
		Double actualGrandTotal = chickenTacoPrice + beefTacoPrice + chorizoTacoPrice + vegetableTacoPrice;
		actualGrandTotal *= 0.8;

		// Use same rounding functionality used in controller.
		actualGrandTotal = Math.round(actualGrandTotal * 100.00) / 100.00;

		Double expectedGrandTotal = 9.6;
		assertEquals(expectedGrandTotal, actualGrandTotal);

	}

	@Test
	public void allChickenWithDiscount() {
		// Find taco prices using latest data from API.
		Double chickenTacoPrice = tacoLocoService.findTacoPrice(1);

		// Calculate actual grand total (with discount) using price data from API
		// retrieved above.
		Double actualGrandTotal = chickenTacoPrice * 8;
		// Use same rounding functionality used in controller.

		actualGrandTotal *= 0.8;
		actualGrandTotal = Math.round(actualGrandTotal * 100.00) / 100.00;

		Double expectedGrandTotal = 19.2;
		assertEquals(expectedGrandTotal, actualGrandTotal);

	}

	@Test
	public void largeOrderWithDiscount() {
		// Find taco prices using latest data from API.
		Double chickenTacoPrice = tacoLocoService.findTacoPrice(1);
		Double beefTacoPrice = tacoLocoService.findTacoPrice(2);
		Double chorizoTacoPrice = tacoLocoService.findTacoPrice(3);
		Double vegetableTacoPrice = tacoLocoService.findTacoPrice(0);

		// Calculate actual grand total (with discount) using price data from API
		// retrieved above.
		Double actualGrandTotal = (chickenTacoPrice * 8) + (beefTacoPrice * 10) + (chorizoTacoPrice * 13)
				+ (vegetableTacoPrice * 30);
		// Use same rounding functionality used in controller.
		actualGrandTotal *= 0.8;
		actualGrandTotal = Math.round(actualGrandTotal * 100.00) / 100.00;

		Double expectedGrandTotal = 139.6;

		assertEquals(expectedGrandTotal, actualGrandTotal);

	}

}
