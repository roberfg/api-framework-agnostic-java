package cl.stringmachine.card.core.application.port.out;

import java.util.List;

import cl.stringmachine.card.core.domain.model.Card;

public interface CardRepository {
	Card saveCard(String cardName);

	List<Card> getAllCards();
}
