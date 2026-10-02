package cl.stringmachine.infra.quarkus.adapter.out.scryfall;

import java.util.Optional;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import cl.stringmachine.card.core.application.port.out.CardSearchPort;
import cl.stringmachine.infra.quarkus.adapter.out.scryfall.dto.ExternalCardDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ScryfallCardSearchAdapter implements CardSearchPort {

	@Inject
	@RestClient
	ScryfallCardRestClient cardRestClient;

	@Override
	public String searchCardName(String cardName) {
		try {
			ExternalCardDto externalCardDto = cardRestClient.getCardByName(cardName);
			return Optional.ofNullable(externalCardDto).map(ExternalCardDto::name).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}
}
