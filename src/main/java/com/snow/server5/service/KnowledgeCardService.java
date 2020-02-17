package com.snow.server5.service;

import com.snow.server5.Global;
import com.snow.server5.entity.card.IssueTag;
import com.snow.server5.entity.card.KnowledgeCard;
import com.snow.server5.entity.card.KnowledgeCardAndIssueTag;
import com.snow.server5.model.card.CardModel;
import com.snow.server5.repository.IssueTagRepository;
import com.snow.server5.repository.KnowledgeCardAndIssueTagRepository;
import com.snow.server5.repository.KnowledgeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnowledgeCardService {

    @Autowired
    private KnowledgeCardRepository knowledgeCardRepository;

    @Autowired
    private IssueTagRepository issueTagRepository;

    @Autowired
    private KnowledgeCardAndIssueTagRepository cardAndIssueTagRepository;

    public List<CardModel> getRandomCards(int pieces){
        List<KnowledgeCard> knowledgeCards;
        if(pieces > Global.CARD_PIECE){
            knowledgeCards = genRandomCards(Global.CARD_PIECE);
            return changeKnowledgeCardToCardModel(knowledgeCards);
        }
        knowledgeCards = genRandomCards(pieces);
        return changeKnowledgeCardToCardModel(knowledgeCards);
    }

    public List<CardModel> getCardsByTag(String ageTag, String issueTagName){
        List<KnowledgeCard> knowledgeCards;

        if(issueTagName.equals("null")){
            String[] ageTags = ageTag.split("-");
            int beginning = Integer.valueOf(ageTags[0]);
            int ending = Integer.valueOf(ageTags[1]);
            knowledgeCards = getCardsByAgeTag(beginning, ending);
            return changeKnowledgeCardToCardModel(knowledgeCards);
        }else{
            knowledgeCards = getKnowledgeCards(getTagByName(issueTagName));
        }

        if(ageTag.equals("null")){
            return changeKnowledgeCardToCardModel(knowledgeCards);
        }else{
            String[] ageTags = ageTag.split("-");
            int beginning = Integer.valueOf(ageTags[0]);
            int ending = Integer.valueOf(ageTags[1]);
            knowledgeCards = getCardsByAgeTag(knowledgeCards, beginning, ending);
            return changeKnowledgeCardToCardModel(knowledgeCards);
        }
    }

    protected IssueTag getTagByName(String tagName){
        return issueTagRepository.findByName(tagName);
    }

    protected IssueTag getTagById(String tagId){
        return issueTagRepository.findByIssueTagId(tagId);
    }

    protected KnowledgeCard getKnowledgeCardById(String cardId){
        return knowledgeCardRepository.findByKnowledgeCardId(Integer.valueOf(cardId));
    }

    protected KnowledgeCard getKnowledgeCardById(int cardId){
        return knowledgeCardRepository.findByKnowledgeCardId(cardId);
    }

    protected List<String> getTags(String cardId){
        KnowledgeCard knowledgeCard = getKnowledgeCardById(cardId);

        List<KnowledgeCardAndIssueTag> knowledgeCardAndIssueTags =
                cardAndIssueTagRepository.findByKnowledgeCard(knowledgeCard);

        List<String> tags = new ArrayList<>();

        for(KnowledgeCardAndIssueTag knowledgeCardAndIssueTag : knowledgeCardAndIssueTags){
            tags.add(knowledgeCardAndIssueTag.getIssueTag().getName());
        }
        return tags;
    }

    protected List<String> getTags(KnowledgeCard knowledgeCard){
        List<KnowledgeCardAndIssueTag> knowledgeCardAndIssueTags =
                cardAndIssueTagRepository.findByKnowledgeCard(knowledgeCard);

        List<String> tags = new ArrayList<>();

        for(KnowledgeCardAndIssueTag knowledgeCardAndIssueTag : knowledgeCardAndIssueTags){
            tags.add(knowledgeCardAndIssueTag.getIssueTag().getName());
        }
        return tags;
    }

    protected List<KnowledgeCard> getKnowledgeCards(IssueTag issueTag){
        List<KnowledgeCardAndIssueTag> knowledgeCardAndIssueTags =
                cardAndIssueTagRepository.findByIssueTag(issueTag);
        List<KnowledgeCard> knowledgeCards = new ArrayList<>();

        for(KnowledgeCardAndIssueTag knowledgeCardAndIssueTag : knowledgeCardAndIssueTags){
            knowledgeCards.add(knowledgeCardAndIssueTag.getKnowledgeCard());
        }
        return knowledgeCards;
    }

    protected List<Integer> genRandomCardIds (){
        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= Global.CARD_PIECE; i++){
            list.add(i);
        }

        for(int i = 0; i < Global.CARD_PIECE; i++){
            int ranNum = (int)(Math.random() * (Global.CARD_PIECE - i) + i);
            int tmp = list.get(i);
            list.set(i, list.get(ranNum));
            list.set(ranNum,tmp);
        }
        return list;
    }

    protected CardModel changeKnowledgeCardToCardModel(KnowledgeCard knowledgeCard){
        CardModel cardModel = new CardModel();
        cardModel.setCardId(String.valueOf(knowledgeCard.getKnowledgeCardId()));
        cardModel.setTitle(knowledgeCard.getTitle());
        cardModel.setContent(knowledgeCard.getContent());
        cardModel.setIssueTags(getTags(knowledgeCard));
        cardModel.setAgeTag
                (knowledgeCard.getBeginningPeriod() + "-" + knowledgeCard.getEndPeriod());
        cardModel.setUrl(knowledgeCard.getUrl());
        cardModel.setReference(knowledgeCard.getReference());
        cardModel.setCardType(1);
        return cardModel;
    }

    protected List<CardModel> changeKnowledgeCardToCardModel(List<KnowledgeCard> knowledgeCards ){
        List<CardModel> cardModels = new ArrayList<>();
        for(KnowledgeCard knowledgeCard : knowledgeCards ){
            cardModels.add(changeKnowledgeCardToCardModel(knowledgeCard));
        }
        return cardModels;
    }

    private List<KnowledgeCard> genRandomCards(int piece){
        List<KnowledgeCard> knowledgeCards = new ArrayList<>();
        List<Integer> cardIds = genRandomCardIds();
        for(int i = 0; i < piece; i++){
            KnowledgeCard knowledgeCard = getKnowledgeCardById(cardIds.get(i));
            knowledgeCards.add(knowledgeCard);
        }
        return knowledgeCards;
    }

    // todo jpa function
    private List<KnowledgeCard> getCardsByAgeTag(int beginning, int ending){
        List<KnowledgeCard> knowledgeCards = knowledgeCardRepository.findByAgeTag(beginning, ending);
        return knowledgeCards;
//        return genRandomCards(3);
    }

    private List<KnowledgeCard> getCardsByAgeTag(List<KnowledgeCard> knowledgeCards, int beginning, int ending){
        List<KnowledgeCard> knowledgeCardList = new ArrayList<>();
        for(KnowledgeCard knowledgeCard : knowledgeCards){
            if(!(ending < knowledgeCard.getBeginningPeriod() || beginning > knowledgeCard.getEndPeriod())){
                knowledgeCardList.add(knowledgeCard);
            }
        }
        return knowledgeCardList;
    }
}
