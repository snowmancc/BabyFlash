package com.snow.server5.repository;

import com.snow.server5.entity.card.IssueTag;
import com.snow.server5.entity.card.KnowledgeCard;
import com.snow.server5.entity.card.KnowledgeCardAndIssueTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnowledgeCardAndIssueTagRepository extends JpaRepository<KnowledgeCardAndIssueTag, Integer> {

    List<KnowledgeCardAndIssueTag> findByKnowledgeCard(KnowledgeCard knowledgeCard);

    List<KnowledgeCardAndIssueTag> findByIssueTag(IssueTag issueTag);
}
