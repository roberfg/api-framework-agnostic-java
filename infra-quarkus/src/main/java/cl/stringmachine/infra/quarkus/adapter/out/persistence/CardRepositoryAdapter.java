package cl.stringmachine.infra.quarkus.adapter.out.persistence;

import java.util.List;

import cl.stringmachine.card.core.application.port.out.CardRepository;
import cl.stringmachine.card.core.domain.model.Card;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CardRepositoryAdapter implements CardRepository {

	@Override
	@Transactional
	public Card saveCard(String cardName) {
		CardEntity entity = new CardEntity(cardName);
		entity.persistAndFlush();
		return new Card(entity.getCardName());
	}

	@Override
	public List<Card> getAllCards() {
		return CardEntity.<CardEntity>listAll().stream().map(entity -> new Card(entity.getCardName())).toList();
	}
}
