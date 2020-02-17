package com.snow.server5.entity.card;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "issuetag")
public class IssueTag {

    @Id
    @Column(unique = true)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String issueTagId;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy="issueTag",fetch = FetchType.EAGER)
    private Set<KnowledgeCardAndIssueTag> knowledgeCardAndIssueTagSet = new HashSet<>();
//
//    @OneToMany(mappedBy="issueTag",fetch = FetchType.EAGER)
//    private Set<MyCardAndIssueTag> myCardAndIssueTagSet = new HashSet<>();
//
//    public Set<MyCardAndIssueTag> getMyCardAndIssueTagSet() {
//        return myCardAndIssueTagSet;
//    }
//
//    public void setMyCardAndIssueTagSet(Set<MyCardAndIssueTag> myCardAndIssueTagSet) {
//        this.myCardAndIssueTagSet = myCardAndIssueTagSet;
//    }

    public Set<KnowledgeCardAndIssueTag> getKnowledgeCardAndIssueTagSet() {
        return knowledgeCardAndIssueTagSet;
    }

    public void setKnowledgeCardAndIssueTagSet(Set<KnowledgeCardAndIssueTag> knowledgeCardAndIssueTagSet) {
        this.knowledgeCardAndIssueTagSet = knowledgeCardAndIssueTagSet;
    }

    public String getIssueTagId() {
        return issueTagId;
    }

    public void setIssueTagId(String issueTagId) {
        this.issueTagId = issueTagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
