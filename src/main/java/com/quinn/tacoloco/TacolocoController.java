package com.quinn.tacoloco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.quinn.tacoloco.model.Taco;

@Controller
public class TacoLocoController {

	@Autowired
	private TacoLocoService tacoLocoService;

	@RequestMapping("/")
	public ModelAndView index() {
// Retrieve up to date menu data from API / JSON and display to user. 
		List<Taco> tacoMenu = this.tacoLocoService.findTacos();

		return new ModelAndView("index", "tacoMenu", tacoMenu);

	}

	@RequestMapping("/invoice")
	public ModelAndView submitOrder(@RequestParam("beefTacoQty") Integer beefTacoQty,
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
		Integer totalTacoQty = beefTacoQty + vegetableTacoQty + chickenTacoQty + chorizoTacoQty;
		if (totalTacoQty >= 4) {
			grandTotal = subTotal * 0.8;
		} else {
			grandTotal = subTotal;
		}

// Add necessary quantities and pricing info to view. 
		ModelAndView mav = new ModelAndView("invoice");
		mav.addObject("vegetablePrice", vegetablePrice);
		mav.addObject("chickenPrice", chickenPrice);
		mav.addObject("beefPrice", beefPrice);
		mav.addObject("chorizoPrice", chorizoPrice);
		mav.addObject("vegetableTacoQty", vegetableTacoQty);
		mav.addObject("beefTacoQty", beefTacoQty);
		mav.addObject("chorizoTacoQty", chorizoTacoQty);
		mav.addObject("chickenTacoQty", chickenTacoQty);
		mav.addObject("subTotal", subTotal);
		mav.addObject("grandTotal", grandTotal);
		mav.addObject("totalTacoQty", totalTacoQty);

		return mav;
	}

}
