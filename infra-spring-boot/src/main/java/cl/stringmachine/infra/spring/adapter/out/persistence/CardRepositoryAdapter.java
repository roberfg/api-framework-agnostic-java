package cl.stringmachine.infra.spring.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cl.stringmachine.card.core.application.port.out.CardRepository;
import cl.stringmachine.card.core.domain.model.Card;

@Component
public class CardRepositoryAdapter implements CardRepository {

	private final JpaRepositoryAdapter jpaRepositoryAdapter;

	public CardRepositoryAdapter(JpaRepositoryAdapter jpaRepositoryAdapter) {
		this.jpaRepositoryAdapter = jpaRepositoryAdapter;
	}

	@Override
	@Transactional
	public Card saveCard(String cardName) {
		CardEntity entity = jpaRepositoryAdapter.save(new CardEntity(null, cardName));
		return new Card(entity.getCardName());
	}

	@Override
	public List<Card> getAllCards() {
		return jpaRepositoryAdapter.findAll().stream().map(entity -> new Card(entity.getCardName())).toList();
	}
}
