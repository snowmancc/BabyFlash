package com.snow.server5.service;

import com.snow.server5.Global;
import com.snow.server5.entity.memebr.Member;
import com.snow.server5.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ImageFileService {

    private static final String BASE_PATH_IMAGE = "./imageFile";

    @Autowired
    private MemberRepository memberRepository;

    public String saveMemberImage(int memberId, MultipartFile imageFile) {
        Member member = memberRepository.findByMemberId(memberId);
        String path = "/" + memberId + System.currentTimeMillis() + ".png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(BASE_PATH_IMAGE + path)){
            byte[] bytes = imageFile.getBytes();
            fileOutputStream.write(bytes);
            member.setImageUrl(Global.SERVER_IP + path);
            memberRepository.save(member);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Global.SERVER_IP + path;
    }

    public String loadMemberImage(int memebrId){
        Member member = memberRepository.findByMemberId(memebrId);
        return member.getImageUrl();
    }

}
