package com.snow.server5.entity.card;

import com.snow.server5.entity.memebr.Member;

import javax.persistence.*;

@Entity
@Table(name = "memberandknowledgecard")
public class MemberAndKnowledgeCard {

    @Id
    @Column(unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberAndKnowledgeCardId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="knowledgeCardId")
    private KnowledgeCard knowledgeCard;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="memberId")
    private Member member;

    @Column(nullable = false)
    private String time;

    private String note;

    public int getMemberAndKnowledgeCardId() {
        return memberAndKnowledgeCardId;
    }

    public void setMemberAndKnowledgeCardId(int memberAndKnowledgeCardId) {
        this.memberAndKnowledgeCardId = memberAndKnowledgeCardId;
    }

    public KnowledgeCard getKnowledgeCard() {
        return knowledgeCard;
    }

    public void setKnowledgeCard(KnowledgeCard knowledgeCard) {
        this.knowledgeCard = knowledgeCard;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
