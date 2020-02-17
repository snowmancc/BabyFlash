package com.snow.server5.repository;

import com.snow.server5.entity.memebr.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

     Member findByEmail(String email);

     Member findByEmailAndPassword(String email, String password);

     Member findByMemberId(int memberId);


}
