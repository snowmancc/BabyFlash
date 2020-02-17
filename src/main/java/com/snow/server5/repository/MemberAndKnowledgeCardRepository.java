package com.snow.server5.repository;

import com.snow.server5.entity.card.KnowledgeCard;
import com.snow.server5.entity.card.MemberAndKnowledgeCard;
import com.snow.server5.entity.memebr.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberAndKnowledgeCardRepository extends JpaRepository<MemberAndKnowledgeCard, Integer> {

    MemberAndKnowledgeCard findByMemberAndKnowledgeCard
            (Member member, KnowledgeCard knowledgeCard);


    //研究一下是啥 加了才可以運作
    @Modifying
    @Transactional
    void deleteByMemberAndKnowledgeCard
            (Member member, KnowledgeCard knowledgeCard);

    boolean existsByKnowledgeCardAndMember(KnowledgeCard knowledgeCard, Member member);

    List<MemberAndKnowledgeCard> findByMember
            (Member member);
}
