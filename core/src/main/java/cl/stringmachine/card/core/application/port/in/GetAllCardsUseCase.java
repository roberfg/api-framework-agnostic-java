package cl.stringmachine.card.core.application.port.in;

import java.util.List;

import cl.stringmachine.card.core.domain.model.Card;

public interface GetAllCardsUseCase {
	List<Card> getAllCards();
}
