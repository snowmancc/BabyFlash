package com.snow.server5.entity.memebr;
import javax.persistence.*;


@Entity
@Table(name = "baby")
public class Baby {

    @Id
    @Column(name = "babyId",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int babyId;

    @Column
    private String name;

    @Column
    private String birthDay;

    @Column
    private int gender;

    @ManyToOne(fetch = FetchType.LAZY) //解決 session 關閉問題!! EAGER -> 熱心
    @JoinColumn(name="memberId")
    private Member member;

    public Integer getBabyId() {
        return babyId;
    }

    public void setBabyId(Integer babyId) {
        this.babyId = babyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthDay;
    }

    public void setBirthday(String birthday) {
        this.birthDay = birthday;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
