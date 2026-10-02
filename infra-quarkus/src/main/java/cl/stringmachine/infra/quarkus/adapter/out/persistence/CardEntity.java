package cl.stringmachine.infra.quarkus.adapter.out.persistence;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class CardEntity extends PanacheEntity {

    @Column(name = "card_name")
    private String cardName;

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public CardEntity() {
    }

    public CardEntity(String cardName) {
        this.cardName = cardName;
    }
}
