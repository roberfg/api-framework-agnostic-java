package cl.stringmachine.infra.quarkus.adapter.in.web;

import cl.stringmachine.card.core.application.port.in.GetAllCardsUseCase;
import cl.stringmachine.card.core.application.port.in.SaveCardUseCase;
import cl.stringmachine.infra.quarkus.adapter.in.web.dto.CardDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/cards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardController {

	private final GetAllCardsUseCase getAllCardsUseCase;

	private final SaveCardUseCase saveCardUseCase;

	@Inject
	public CardController(GetAllCardsUseCase getAllCardsUseCase, SaveCardUseCase saveCardUseCase) {
		this.getAllCardsUseCase = getAllCardsUseCase;
		this.saveCardUseCase = saveCardUseCase;
	}

	@POST
	public Response saveCard(CardDto body) {
		saveCardUseCase.saveCard(body.cardName());
		return Response.status(Response.Status.CREATED).build();

	}

	@GET
	public Response getAllCards() {
		return Response.status(Response.Status.OK)
				.entity(getAllCardsUseCase.getAllCards().stream().map(c -> new CardDto(c.cardName())).toList()).build();
	}

}
