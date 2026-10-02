package cl.stringmachine.infra.spring.adapter.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardDto(@JsonProperty(value = "card_name") String cardName) {

}
