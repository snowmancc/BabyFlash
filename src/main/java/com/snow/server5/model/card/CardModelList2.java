package com.snow.server5.model.card;

import com.snow.server5.model.ModelCarrier;

import java.util.List;

public class CardModelList2 implements ModelCarrier {

    private List<ModelCarrier> cards;

    public List<ModelCarrier> getCards() {
        return cards;
    }

    public void setCards(List<ModelCarrier> cards) {
        this.cards = cards;
    }

    public CardModelList2(List<ModelCarrier> cards) {
        this.cards = cards;
    }
}
