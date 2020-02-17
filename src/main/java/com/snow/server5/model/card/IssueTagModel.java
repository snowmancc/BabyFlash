package com.snow.server5.model.card;

import com.snow.server5.model.ModelCarrier;

public class IssueTagModel implements ModelCarrier {

    private String issueTag;

    public String getIssueTag() {
        return issueTag;
    }

    public void setIssueTag(String issueTag) {
        this.issueTag = issueTag;
    }
}
