package cl.stringmachine.infra.spring.adapter.out.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "card_name")
    private String cardName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public CardEntity(Long id, String cardName) {
        this.id = id;
        this.cardName = cardName;
    }

    public CardEntity() {
    }
}
