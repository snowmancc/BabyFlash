package com.snow.server5.model.card;

import com.snow.server5.model.ModelCarrier;

import java.util.List;

public class MemberCardModel implements ModelCarrier {
    private String title;
    private String content;
    private List<String> issueTags;
    private String ageTag;
    private String reference;
    private String time;

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
