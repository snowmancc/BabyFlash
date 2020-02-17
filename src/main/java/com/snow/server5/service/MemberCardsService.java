package com.snow.server5.service;

import com.snow.server5.Global;
import com.snow.server5.entity.memebr.Member;
import com.snow.server5.entity.mycard.Mycard;
import com.snow.server5.exception.http.NotFoundException;
import com.snow.server5.model.card.FavoriteCardModelOfMyCard;
import com.snow.server5.repository.MemberRepository;
import com.snow.server5.repository.MyCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberCardsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MyCardRepository myCardRepository;

    @Autowired
    private MemberFavoriteKnowledgeCardService memberFavoriteKnowledgeCardService;

    public static final String BASE_PATH_MYCARD = "./imageFile";

    public void createCard(int memberId, MultipartFile file, String note){
        String noteStr = note;
        Member member = memberRepository.findByMemberId(memberId);
        Mycard mycard = new Mycard();
        mycard.setNote(noteStr);
        mycard.setTime(memberFavoriteKnowledgeCardService.getCurrentTime());
        String url = writeFileAndGetFileUrl(file);
        mycard.setUrl(url);
        mycard.setMember(member);
        member.getMyCards().add(mycard);
        memberRepository.save(member);
        myCardRepository.save(mycard);
    }

    public void addNote(int myCardId, String note) throws NotFoundException {
        Mycard mycard = myCardRepository.findBymyCardId(myCardId);
        mycard.setNote(note);
        myCardRepository.save(mycard);
    }

    private String writeFileAndGetFileUrl(MultipartFile file){
        String path = "/" + System.currentTimeMillis() + ".png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(BASE_PATH_MYCARD + path)){
            byte[] bytes = file.getBytes();
            fileOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Global.SERVER_IP + path;
    }

    public List<FavoriteCardModelOfMyCard> getFavoriteCardModelOfMyCard(Member member){
        Set<Mycard> mycardList = member.getMyCards();
        List<FavoriteCardModelOfMyCard> favoriteCardModelOfMyCards =
                new ArrayList<>();

        for(Mycard mycard : mycardList){
            FavoriteCardModelOfMyCard favoriteCardModelOfMyCard = new FavoriteCardModelOfMyCard();
            favoriteCardModelOfMyCard.setCardId("" + mycard.getMyCardId());
            favoriteCardModelOfMyCard.setCardType(2);
            favoriteCardModelOfMyCard.setNote(mycard.getNote());
            favoriteCardModelOfMyCard.setTime(mycard.getTime());
            favoriteCardModelOfMyCard.setUrl(mycard.getUrl());
            favoriteCardModelOfMyCards.add(favoriteCardModelOfMyCard);
        }
        return favoriteCardModelOfMyCards;
    }

    public void cancelMyCard(int memberId, int myCardId){
        Member member = memberRepository.findByMemberId(memberId);
        Mycard mycard = myCardRepository.findBymyCardId(myCardId);
        member.getMyCards().remove(mycard);
        memberRepository.save(member);
        myCardRepository.delete(mycard);
    }
}
