package com.snow.server5.model.card;

import com.snow.server5.model.ModelCarrier;

import java.util.List;

public class CardModel implements ModelCarrier {
    private String cardId;
    private String title;
    private String content;
    private List<String> issueTags;
    private String ageTag;
    private String reference;
    private String url;
    private int cardType;

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getIssueTags() {
        return issueTags;
    }

    public void setIssueTags(List<String> issueTags) {
        this.issueTags = issueTags;
    }

    public String getAgeTag() {
        return ageTag;
    }

    public void setAgeTag(String ageTag) {
        this.ageTag = ageTag;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
