package com.snow.server5.repository;

import com.snow.server5.entity.card.IssueTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueTagRepository extends JpaRepository<IssueTag, Integer> {

    IssueTag findByIssueTagId(String issueTagId);

    IssueTag findByName(String name);
}
