package com.snow.server5.repository;

import com.snow.server5.entity.memebr.Member;
import com.snow.server5.entity.mycard.Mycard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface MyCardRepository extends JpaRepository<Mycard, Integer> {

    Mycard findBymyCardId(int myCardId);

}
