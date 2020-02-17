package com.snow.server5.service;

import com.snow.server5.entity.card.KnowledgeCard;
import com.snow.server5.entity.card.MemberAndKnowledgeCard;
import com.snow.server5.entity.memebr.Member;
import com.snow.server5.exception.http.NotFoundException;
import com.snow.server5.model.card.CardModel;
import com.snow.server5.model.card.FavoriteCardModelOfKnowledge;
import com.snow.server5.repository.KnowledgeCardRepository;
import com.snow.server5.repository.MemberAndKnowledgeCardRepository;
import com.snow.server5.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemberFavoriteKnowledgeCardService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAndKnowledgeCardRepository memberAndKnowledgeCardRepository;

    @Autowired
    private KnowledgeCardRepository knowledgeCardRepository;

    @Autowired
    private KnowledgeCardService knowledgeCardService;

    public void recordMemberFavoriteKnowledge(String memberId, String cardId, String note) throws NotFoundException {
        KnowledgeCard knowledgeCard = knowledgeCardRepository.findByKnowledgeCardId
                (Integer.valueOf(cardId));
        Member member = memberRepository.findByMemberId(Integer.valueOf(memberId));

        if(checkMemberRecordExist(knowledgeCard, member)){
            MemberAndKnowledgeCard memberAndKnowledgeCard =
                    getRecord(knowledgeCard, member);
            memberAndKnowledgeCard.setNote(note);
            memberAndKnowledgeCardRepository.save(memberAndKnowledgeCard);
        }else{
            createRecord(knowledgeCard, member, note);
        }
    }

    public void cancelMemberFavoriteKnowledge(String memberId, String cardId) {
        KnowledgeCard knowledgeCard = knowledgeCardRepository.findByKnowledgeCardId
                (Integer.valueOf(cardId));
        Member member = memberRepository.findByMemberId(Integer.valueOf(memberId));

        if(checkMemberRecordExist(knowledgeCard, member)){
            memberAndKnowledgeCardRepository.deleteByMemberAndKnowledgeCard(member, knowledgeCard);
        }
    }

    protected List<FavoriteCardModelOfKnowledge> getMemberFavoriteKnowledgeCards(Member member){
        List<MemberAndKnowledgeCard> memberAndKnowledgeCardList = memberAndKnowledgeCardRepository.findByMember(member);
        List<FavoriteCardModelOfKnowledge> knowledgeCards = new ArrayList<>();
        FavoriteCardModelOfKnowledge favoriteCardModelOfKnowledge;
        for(MemberAndKnowledgeCard memberAndKnowledgeCard : memberAndKnowledgeCardList){
            favoriteCardModelOfKnowledge = changeKnowledgeToFavoriteCardModel
                    (memberAndKnowledgeCard.getKnowledgeCard());
            favoriteCardModelOfKnowledge.setNote(memberAndKnowledgeCard.getNote());
            favoriteCardModelOfKnowledge.setTime(memberAndKnowledgeCard.getTime());
            knowledgeCards.add(favoriteCardModelOfKnowledge);
        }
        return knowledgeCards;
    }

    protected FavoriteCardModelOfKnowledge changeKnowledgeToFavoriteCardModel(KnowledgeCard knowledgeCard){
        FavoriteCardModelOfKnowledge favoriteCardModelOfKnowledge = new FavoriteCardModelOfKnowledge();
        favoriteCardModelOfKnowledge.setCardId(String.valueOf(knowledgeCard.getKnowledgeCardId()));
        favoriteCardModelOfKnowledge.setTitle(knowledgeCard.getTitle());
        favoriteCardModelOfKnowledge.setContent(knowledgeCard.getContent());
        favoriteCardModelOfKnowledge.setAgeTag
                (knowledgeCard.getBeginningPeriod() + "-" + knowledgeCard.getEndPeriod());
        favoriteCardModelOfKnowledge.setIssueTags
                (knowledgeCardService.getTags(knowledgeCard));
        favoriteCardModelOfKnowledge.setUrl(knowledgeCard.getUrl());
        favoriteCardModelOfKnowledge.setReference(knowledgeCard.getReference());
        favoriteCardModelOfKnowledge.setCardType(1);
        return favoriteCardModelOfKnowledge;
    }

    protected boolean checkMemberRecordExist(KnowledgeCard knowledgeCard, Member member) {
        return memberAndKnowledgeCardRepository.existsByKnowledgeCardAndMember
                (knowledgeCard, member);
    }

    protected String getCurrentTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdFormat.format(date);
        return time;
    }

    protected MemberAndKnowledgeCard getRecord(KnowledgeCard knowledgeCard, Member member) {
        return memberAndKnowledgeCardRepository.findByMemberAndKnowledgeCard
                (member, knowledgeCard);
    }

    protected void createRecord(KnowledgeCard knowledgeCard, Member member, String note){
        MemberAndKnowledgeCard memberAndKnowledgeCard = new MemberAndKnowledgeCard();
        memberAndKnowledgeCard.setMember(member);
        memberAndKnowledgeCard.setKnowledgeCard(knowledgeCard);
        memberAndKnowledgeCard.setNote(note);
        memberAndKnowledgeCard.setTime(getCurrentTime());
        memberAndKnowledgeCardRepository.save(memberAndKnowledgeCard);
    }
}
