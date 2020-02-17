package com.snow.server5.repository;

import com.snow.server5.entity.memebr.Baby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BabyRepository extends JpaRepository<Baby, Integer> {

}
