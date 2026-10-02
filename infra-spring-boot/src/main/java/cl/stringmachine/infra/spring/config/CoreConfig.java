package cl.stringmachine.infra.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.stringmachine.card.core.application.port.out.CardRepository;
import cl.stringmachine.card.core.application.port.out.CardSearchPort;
import cl.stringmachine.card.core.application.service.CardService;

@Configuration
public class CoreConfig {

	@Bean
	CardService cardService(CardRepository cardRepository, CardSearchPort cardSearchPort) {
		return new CardService(cardRepository, cardSearchPort);
	}
}
