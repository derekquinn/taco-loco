package com.quinn.tacoloco;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.quinn.tacoloco.model.Taco;
import com.quinn.tacoloco.model.TacoResponse;

@Component
public class TacolocoService {

	private RestTemplate restTemplate = new RestTemplate();

	public List<Taco> findTacos() {
		String url = "https://api.myjson.com/bins/g4q8s";
		TacoResponse response = restTemplate.getForObject(url, TacoResponse.class);
		return response.getTacos();
	}

}
