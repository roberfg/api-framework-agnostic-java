package cl.stringmachine.infra.spring.adapter.out.scryfall;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.stringmachine.card.core.application.port.out.CardSearchPort;
import cl.stringmachine.infra.spring.adapter.out.scryfall.dto.ExternalCardDto;

@Component
public class ScryfallCardSearchAdapter implements CardSearchPort {

	private final RestTemplate restTemplate;

	private static final String BASE_URL = "https://api.scryfall.com/cards/named?fuzzy=";

	public ScryfallCardSearchAdapter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String searchCardName(String cardName) {
		try {
			String url = BASE_URL + cardName;
			ResponseEntity<ExternalCardDto> response = restTemplate.getForEntity(url, ExternalCardDto.class);
			return Optional.ofNullable(response.getBody()).map(ExternalCardDto::name).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
}
