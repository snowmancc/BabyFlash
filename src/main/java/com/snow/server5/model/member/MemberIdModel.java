package com.snow.server5.model.member;

import com.snow.server5.model.ModelCarrier;

public class MemberIdModel implements ModelCarrier {

    private String memberId;

    public MemberIdModel(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

}
