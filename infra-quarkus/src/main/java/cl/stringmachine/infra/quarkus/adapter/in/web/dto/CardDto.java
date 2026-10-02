package cl.stringmachine.infra.quarkus.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardDto(@JsonProperty("card_name") String cardName) {

}
