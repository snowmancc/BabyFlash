package com.snow.server5.model.member;

import com.snow.server5.model.ModelCarrier;
import com.snow.server5.model.member.BabyModel;

import java.util.List;

public class MemberInfoModel implements ModelCarrier {
    private String name;
    private String birthDay;
    private int gender;
    private List<BabyModel> babies;
    private String imageUrl;

    public MemberInfoModel(String name, String birthDay, int gender, List<BabyModel> babies, String imageUrl) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.babies = babies;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
