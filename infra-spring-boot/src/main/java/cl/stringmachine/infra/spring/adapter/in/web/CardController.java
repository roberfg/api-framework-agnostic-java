package cl.stringmachine.infra.spring.adapter.in.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.stringmachine.card.core.application.port.in.GetAllCardsUseCase;
import cl.stringmachine.card.core.application.port.in.SaveCardUseCase;
import cl.stringmachine.infra.spring.adapter.in.web.dto.CardDto;

@RestController
@RequestMapping("/api/cards")
public class CardController {

	private final SaveCardUseCase saveCardUseCase;

	private final GetAllCardsUseCase getAllCardsUseCase;

	public CardController(SaveCardUseCase saveCardUseCase, GetAllCardsUseCase getAllCardsUseCase) {
		this.saveCardUseCase = saveCardUseCase;
		this.getAllCardsUseCase = getAllCardsUseCase;
	}

	@PostMapping()
	public ResponseEntity<Void> saveCard(@RequestBody CardDto body) {
		saveCardUseCase.saveCard(body.cardName());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping()
	public ResponseEntity<List<CardDto>> getAllCards() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(getAllCardsUseCase.getAllCards().stream().map(c -> new CardDto(c.cardName())).toList());
	}
}
