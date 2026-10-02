package cl.stringmachine.infra.quarkus.adapter.out.scryfall.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExternalCardDto(String name) {
}
