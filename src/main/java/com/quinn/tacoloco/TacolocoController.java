package com.quinn.tacoloco;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.quinn.tacoloco.model.Order;
import com.quinn.tacoloco.model.Taco;

@RestController
public class TacoLocoController {
	
// Decimal formatter to keep two decimal places proper for currency. 
	NumberFormat formatter = new DecimalFormat("#0.00");
	
	@Autowired
	private TacoLocoService tacoLocoService;

	@RequestMapping("/")
	public ModelAndView index() {
// Retrieve up to date menu data from API / JSON and display to user. 
		List<Taco> tacoMenu = this.tacoLocoService.findTacos();

		return new ModelAndView("index", "tacoMenu", tacoMenu);

	}

// Invoice shows quantities of each item ordered, subtotal and grand total. 
	@RequestMapping("/invoice")
	public Order submitOrder(@RequestParam("beefTacoQty") Integer beefTacoQty,
			@RequestParam("vegetableTacoQty") Integer vegetableTacoQty,
			@RequestParam("chickenTacoQty") Integer chickenTacoQty,
			@RequestParam("chorizoTacoQty") Integer chorizoTacoQty) {

// Find taco prices using latest data from API. 
		Double vegetablePrice = tacoLocoService.findTacoPrice(0);
		Double chickenPrice = tacoLocoService.findTacoPrice(1);
		Double beefPrice = tacoLocoService.findTacoPrice(2);
		Double chorizoPrice = tacoLocoService.findTacoPrice(3);

// Calculate subtotal based on quantities * price; 

		Double subTotal = (vegetablePrice * vegetableTacoQty) + (beefTacoQty * beefPrice)
				+ (chickenPrice * chickenTacoQty) + (chorizoTacoQty * chorizoPrice);

// Calculate grand total and account for discount if more than 4 tacos are ordered.
		Double grandTotal;
		Boolean discountApplied;
		Integer totalTacoQty = beefTacoQty + vegetableTacoQty + chickenTacoQty + chorizoTacoQty;
		if (totalTacoQty >= 4) {
			grandTotal = subTotal * 0.8;
			discountApplied = true;
			
		} else {
			grandTotal = subTotal;
			discountApplied = false;
		}
		
		subTotal = Math.round(subTotal * 100.00)/100.00;
		grandTotal =  Math.round(grandTotal * 100.00)/100.00;

// Create Order object and return as JSON. 		
		Order order = new Order();
		order.setBeefTacoQty(beefTacoQty);
		order.setChickenTacoQty(chickenTacoQty);
		order.setChorizoTacoQty(chorizoTacoQty);
		order.setVegetableTacoQty(vegetableTacoQty);
		order.setGrandTotal(grandTotal);
		order.setSubTotal(subTotal);
		order.setDiscountApplied(discountApplied);

		return order;
	}

}
