package com.example.web_store.repo;

import com.example.web_store.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodRepository extends JpaRepository<Good, Integer> {
    Good findGoodById(Integer id);
}
