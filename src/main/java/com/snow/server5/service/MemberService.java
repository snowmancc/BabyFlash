package com.snow.server5.service;
import com.snow.server5.entity.memebr.Baby;
import com.snow.server5.entity.memebr.Member;
import com.snow.server5.exception.http.NotFoundException;
import com.snow.server5.model.member.BabyModel;
import com.snow.server5.model.member.MemberInfoModel;
import com.snow.server5.model.member.MemberModel;
import com.snow.server5.repository.BabyRepository;
import com.snow.server5.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BabyRepository babyRepository;

    public boolean checkEmailExists(String email){
        return (memberRepository.findByEmail(email) != null);
    }

    public boolean checkMemberExits(String memberId){
        return memberRepository.findByMemberId(Integer.valueOf(memberId)) != null;
    }

    public String getMemberId(String email){
        return String.valueOf(memberRepository.findByEmail(email).getMemberId());
    }

    public String getMemberImageUrl(String email){
        return memberRepository.findByEmail(email).getImageUrl();
    }
//
    public void addMember(MemberModel memberModel) {
        Member member = new Member();
        member.setName(memberModel.getName());
        member.setEmail(memberModel.getEmail());
        member.setPassword(memberModel.getPassword());
        member.setBirthDay(memberModel.getBirthDay());
        member.setGender(memberModel.getGender());
        member.setImageUrl("");

        Set<Baby> babies = new HashSet<>();

        for(BabyModel babyModel : memberModel.getBabies()){
            Baby baby = new Baby();
            baby.setName(babyModel.getName());
            baby.setBirthday(babyModel.getBirthDay());
            baby.setGender(babyModel.getGender());
            baby.setMember(member);
            babies.add(baby);
        }

        member.setBabies(babies);
        memberRepository.save(member);
        babyRepository.saveAll(babies);

    }

    public boolean checkCertification(String email, String password){
        return memberRepository.findByEmailAndPassword(email, password) != null;
    }

    public String createToken(String email, String password){
        Member member = memberRepository.findByEmail(email);
        member.setToken(String.valueOf(System.currentTimeMillis()));
        memberRepository.save(member);
        return member.getToken();
    }

    public boolean verifyToken(int id, String token) {
        Member member = memberRepository.findByMemberId(id);
        return member.getToken().equals(token);
    }

    public boolean verifyToken(String token) {
        return true;
    }

    public MemberInfoModel getMemberInfo(String memberId){
        if(checkMemberExits(memberId)){
            Member member = memberRepository.findByMemberId(Integer.valueOf(memberId));
            Set<Baby> babies = member.getBabies();
            List<BabyModel> babyModels = new ArrayList<>();

            for(Baby baby : babies){
                BabyModel babyModel = new BabyModel();
                babyModel.setName(baby.getName());
                babyModel.setBirthDay(baby.getBirthday());
                babyModel.setGender(baby.getGender());
                babyModel.setId(String.valueOf(baby.getBabyId()));
                babyModels.add(babyModel);
            }

            return new MemberInfoModel(member.getName(), member.getBirthDay(), member.getGender(), babyModels, member.getImageUrl());
        }
        throw new NotFoundException("Not found data!");
    }

    public void deleteBabiesByMemberId(String memberId){
        Member member = memberRepository.findByMemberId(Integer.valueOf(memberId));
        Set<Baby> babies = member.getBabies();
        babyRepository.deleteAll(babies);
        member.getBabies().clear();
        memberRepository.save(member);
    }

    public void updateMemberInfo(String memberId, MemberInfoModel memberInfo) {

        if(!checkMemberExits(memberId)){
            throw new NotFoundException("Not found data!");
        }

        deleteBabiesByMemberId(memberId);
        Member member = memberRepository.findByMemberId(Integer.valueOf(memberId));
        member.setName(memberInfo.getName());
        member.setBirthDay(memberInfo.getBirthDay());
        member.setGender(memberInfo.getGender());

        List<BabyModel> babyModels = memberInfo.getBabies();
        Set<Baby> babies = member.getBabies();

        for(BabyModel babyModel : memberInfo.getBabies()){
            Baby baby = new Baby();
            baby.setName(babyModel.getName());
            baby.setBirthday(babyModel.getBirthDay());
            baby.setGender(babyModel.getGender());
            baby.setMember(member);
            babyRepository.save(baby);
            babies.add(baby);
        }

        member.setBabies(babies);
        memberRepository.save(member);

    }

    public void saveFile(String memberId, MultipartFile file){

    }
}
