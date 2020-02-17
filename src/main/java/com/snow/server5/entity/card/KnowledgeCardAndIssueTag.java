package com.snow.server5.entity.card;

import javax.persistence.*;

@Entity
@Table(name = "knowledgecardandissuetag")
public class KnowledgeCardAndIssueTag {

    @Id
    @Column(unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int knowledgeCardAndIssueTagId;

    @ManyToOne(fetch = FetchType.EAGER) //解決 session 關閉問題!!
    @JoinColumn(name="knowledgeCardId")
    private KnowledgeCard knowledgeCard;

    @ManyToOne(fetch = FetchType.EAGER) //解決 session 關閉問題!!
    @JoinColumn(name="issueTagId")
    private IssueTag issueTag;

    public int getKnowledgeCardAndIssueTagId() {
        return knowledgeCardAndIssueTagId;
    }

    public void setKnowledgeCardAndIssueTagId(int id) {
        this.knowledgeCardAndIssueTagId = id;
    }

    public KnowledgeCard getKnowledgeCard() {
        return knowledgeCard;
    }

    public void setKnowledgeCard(KnowledgeCard knowledgeCard) {
        this.knowledgeCard = knowledgeCard;
    }

    public IssueTag getIssueTag() {
        return issueTag;
    }

    public void setIssueTag(IssueTag issueTag) {
        this.issueTag = issueTag;
    }
}
