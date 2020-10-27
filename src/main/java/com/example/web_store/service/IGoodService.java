package com.example.web_store.service;

import com.example.web_store.model.CreateGood;
import com.example.web_store.model.Good;

import java.util.List;

public interface IGoodService {
    Good getGoodById(Integer Id);
    Good save(Good good);
    void deleteById(Integer id);
    Good createGood(CreateGood createGood);
    List<Good> getAllGoods();
}
