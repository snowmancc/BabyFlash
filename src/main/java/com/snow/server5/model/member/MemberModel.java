package com.snow.server5.model.member;

import com.snow.server5.model.ModelCarrier;
import com.snow.server5.model.member.BabyModel;

import java.util.List;

public class MemberModel implements ModelCarrier {
    private String email;
    private String password;
    private String name;
    private String birthDay;
    private int gender;
    private List<BabyModel> babies;

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
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<BabyModel> getBabies() {
        return babies;
    }

    public void setBabies(List<BabyModel> babies) {
        this.babies = babies;
    }

}
