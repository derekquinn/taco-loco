package com.quinn.tacoloco;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.quinn.tacoloco.model.Taco;
import com.quinn.tacoloco.model.TacoResponse;

@Component
public class TacoLocoService {

	private RestTemplate restTemplate = new RestTemplate();

// Retrieve all tacos from JSON / API. 
	public List<Taco> findTacos() {
		String url = "https://api.myjson.com/bins/1cjv7w";
		TacoResponse response = restTemplate.getForObject(url, TacoResponse.class);
		return response.getTacos();
	}

// Find individual taco price by searching with Taco ID to allow dynamic summation of taco prices. 
	public Double findTacoPrice(Integer tacoId) {

		String url = "https://api.myjson.com/bins/1cjv7w";
		TacoResponse response = restTemplate.getForObject(url, TacoResponse.class);

		List<Taco> tacos = response.getTacos();
		Taco taco = tacos.get(tacoId);
		Double tacoPrice = taco.getPrice();

		return tacoPrice;
	}

}
