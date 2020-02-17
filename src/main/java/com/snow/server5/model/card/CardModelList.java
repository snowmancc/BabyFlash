package com.snow.server5.model.card;

import com.snow.server5.model.ModelCarrier;

import java.util.List;

public class CardModelList implements ModelCarrier {

    private List<CardModel> cards;

    public CardModelList(List<CardModel> cards) {
        this.cards = cards;
    }

    public List<CardModel> getCards() {
        return cards;
    }

    public void setCards(List<CardModel> cards) {
        this.cards = cards;
    }
}
