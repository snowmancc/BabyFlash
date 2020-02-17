package com.snow.server5.service;

import com.snow.server5.entity.memebr.Member;
import com.snow.server5.model.ModelCarrier;
import com.snow.server5.model.card.FavoriteCardModelOfKnowledge;
import com.snow.server5.model.card.FavoriteCardModelOfMyCard;
import com.snow.server5.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberFavoriteCardsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberFavoriteKnowledgeCardService memberFavoriteKnowledgeCardService;

    @Autowired
    private MemberCardsService memberCardsService;

    public List<ModelCarrier> getMemberCards(int memberId){
        Member member = memberRepository.findByMemberId(memberId);
        List<FavoriteCardModelOfKnowledge> knowledgeCards =
                memberFavoriteKnowledgeCardService.getMemberFavoriteKnowledgeCards(member);
        List<FavoriteCardModelOfMyCard> myCards =
                memberCardsService.getFavoriteCardModelOfMyCard(member);
        List<ModelCarrier> modelCarrierList = new ManagedList<>();
        modelCarrierList = changeKnowledgeCardsToModelCarrier(knowledgeCards, modelCarrierList);
        modelCarrierList = changeMyCardCardsToModelCarrier(myCards, modelCarrierList);
        return modelCarrierList;
    }

    private List<ModelCarrier> changeKnowledgeCardsToModelCarrier
            (List<FavoriteCardModelOfKnowledge> favoriteCardModelOfKnowledgeList, List<ModelCarrier> modelCarrierList){
        for(FavoriteCardModelOfKnowledge favoriteCardModelOfKnowledge : favoriteCardModelOfKnowledgeList){
            modelCarrierList.add(favoriteCardModelOfKnowledge);
        }
        return modelCarrierList;
    }

    private List<ModelCarrier> changeMyCardCardsToModelCarrier
            (List<FavoriteCardModelOfMyCard> favoriteCardModelOfMyCards, List<ModelCarrier> modelCarrierList){
        for(FavoriteCardModelOfMyCard favoriteCardModelOfMyCard : favoriteCardModelOfMyCards){
            modelCarrierList.add(favoriteCardModelOfMyCard);
        }
        return modelCarrierList;
    }

}
