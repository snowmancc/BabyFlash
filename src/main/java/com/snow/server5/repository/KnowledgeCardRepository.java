package com.snow.server5.repository;


import com.snow.server5.entity.card.KnowledgeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KnowledgeCardRepository extends JpaRepository<KnowledgeCard, Integer> {

    KnowledgeCard findByKnowledgeCardId(int KnowledgeCardId);

    @Query(value =
            "select k from KnowledgeCard k where not(k.beginningPeriod > ?2 or k.endPeriod < ?1)")
    List<KnowledgeCard> findByAgeTag(int beginning, int ending);

}
