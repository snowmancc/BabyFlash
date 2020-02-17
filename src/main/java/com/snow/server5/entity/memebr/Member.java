package com.snow.server5.entity.memebr;
import com.snow.server5.entity.card.MemberAndKnowledgeCard;
import com.snow.server5.entity.mycard.Mycard;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "memberinfo")
public class Member {

    @Id
    @Column(unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @Column
    private String birthday;

    @Column
    private String imageUrl;

    @Column
    private int gender;

    @Column
    private String token;

    @OneToMany( mappedBy="member",fetch = FetchType.EAGER)
    private Set<Baby> babies = new HashSet<>();

    @OneToMany( mappedBy="member",fetch = FetchType.EAGER)
    private Set<Mycard> myCards = new HashSet<>();

    @OneToMany( mappedBy="member",fetch = FetchType.EAGER)
    private Set<MemberAndKnowledgeCard> MemberAndKnowledgeCard = new HashSet<>();

    public Set<Baby> getBabies() {
        return babies;
    }

    public void setBabies(Set<Baby> babies) {
        this.babies = babies;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthday;
    }

    public void setBirthDay(String birthDay) {
        this.birthday = birthDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Set<MemberAndKnowledgeCard> getMemberAndKnowledgeCard() {
        return MemberAndKnowledgeCard;
    }

    public void setMemberAndKnowledgeCard(Set<MemberAndKnowledgeCard> memberAndKnowledgeCard) {
        MemberAndKnowledgeCard = memberAndKnowledgeCard;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Mycard> getMyCards() {
        return myCards;
    }

    public void setMyCards(Set<Mycard> myCards) {
        this.myCards = myCards;
    }
}
