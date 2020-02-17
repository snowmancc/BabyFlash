package com.snow.server5.entity.mycard;

import com.snow.server5.entity.memebr.Member;

import javax.persistence.*;

@Entity
@Table(name = "mycard")
public class Mycard {
    @Id
    @Column(name = "myCardId",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int myCardId;

    private String url;

    private String time;

    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="memberId")
    private Member member;

    public int getMyCardId() {
        return myCardId;
    }

    public void setMyCardId(int myCardId) {
        this.myCardId = myCardId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
