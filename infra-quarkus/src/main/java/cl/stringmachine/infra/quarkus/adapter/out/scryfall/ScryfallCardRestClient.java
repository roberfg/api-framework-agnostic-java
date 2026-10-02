package cl.stringmachine.infra.quarkus.adapter.out.scryfall;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import cl.stringmachine.infra.quarkus.adapter.out.scryfall.dto.ExternalCardDto;

@RegisterRestClient(baseUri = "https://api.scryfall.com")
public interface ScryfallCardRestClient {

    @GET
    @Path("/cards/named")
    ExternalCardDto getCardByName(@QueryParam("fuzzy") String cardName);
}
