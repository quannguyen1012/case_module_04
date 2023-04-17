package com.cg.repository;

import com.cg.model.entity.MadeIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MadeInRepository extends JpaRepository<MadeIn, Long> {
}
