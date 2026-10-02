package cl.stringmachine.card.core.application.service;

import java.util.List;

import cl.stringmachine.card.core.application.port.in.GetAllCardsUseCase;
import cl.stringmachine.card.core.application.port.in.SaveCardUseCase;
import cl.stringmachine.card.core.application.port.out.CardRepository;
import cl.stringmachine.card.core.application.port.out.CardSearchPort;
import cl.stringmachine.card.core.domain.model.Card;

public class CardService implements GetAllCardsUseCase, SaveCardUseCase {

	private final CardRepository cardRepository;
	private final CardSearchPort cardSearchPort;

	public CardService(CardRepository cardRepository, CardSearchPort cardSearchPort) {
		this.cardRepository = cardRepository;
		this.cardSearchPort = cardSearchPort;
	}

	@Override
	public void saveCard(String cardName) {
		String validatedCardName = getValidatedCardName(cardName);
		cardRepository.saveCard(validatedCardName);
	}

	@Override
	public List<Card> getAllCards() {
		return cardRepository.getAllCards();
	}

	private String getValidatedCardName(String cardName) {
		return cardSearchPort.searchCardName(cardName);
	}

}
