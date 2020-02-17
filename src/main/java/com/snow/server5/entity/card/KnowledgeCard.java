package com.snow.server5.entity.card;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "knowledgecard")
public class KnowledgeCard {

    @Id
    @Column(unique = true,nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int knowledgeCardId;

    private String title;

    private String content;

    private int beginningPeriod;

    private int endPeriod;

    private String reference;

    private String url;

    @OneToMany(mappedBy="knowledgeCard",fetch = FetchType.EAGER)
    private Set<KnowledgeCardAndIssueTag> knowledgeCardAndIssueTagSet = new HashSet<>();

    @OneToMany(mappedBy="knowledgeCard",fetch = FetchType.EAGER)
    private Set<MemberAndKnowledgeCard> memberAndKnowledgeCardSet = new HashSet<>();

    public Set<MemberAndKnowledgeCard> getMemberAndKnowledgeCardSet() {
        return memberAndKnowledgeCardSet;
    }

    public void setMemberAndKnowledgeCardSet(Set<MemberAndKnowledgeCard> memberAndKnowledgeCardSet) {
        this.memberAndKnowledgeCardSet = memberAndKnowledgeCardSet;
    }

    public int getKnowledgeCardId() {
        return knowledgeCardId;
    }

    public void setKnowledgeCardId(int knowledgeCardId) {
        this.knowledgeCardId = knowledgeCardId;
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


    public int getBeginningPeriod() {
        return beginningPeriod;
    }

    public void setBeginningPeriod(int beginningPeriod) {
        this.beginningPeriod = beginningPeriod;
    }

    public int getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(int endPeriod) {
        this.endPeriod = endPeriod;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<KnowledgeCardAndIssueTag> getKnowledgeCardAndIssueTagSet() {
        return knowledgeCardAndIssueTagSet;
    }

    public void setKnowledgeCardAndIssueTagSet(Set<KnowledgeCardAndIssueTag> knowledgeCardAndIssueTagSet) {
        this.knowledgeCardAndIssueTagSet = knowledgeCardAndIssueTagSet;
    }
}
