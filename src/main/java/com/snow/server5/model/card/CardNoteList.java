package com.snow.server5.model.card;

import com.snow.server5.model.ModelCarrier;

import java.util.List;

public class CardNoteList implements ModelCarrier {

    private List<CardNoteModel> cards;

    public CardNoteList(List<CardNoteModel> cards) {
        this.cards = cards;
    }

    public List<CardNoteModel> getCards() {
        return cards;
    }

    public void setCards(List<CardNoteModel> cards) {
        this.cards = cards;
    }
}
