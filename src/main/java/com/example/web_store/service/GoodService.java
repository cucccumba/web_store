package com.example.web_store.service;

import com.example.web_store.model.CreateGood;
import com.example.web_store.model.Good;
import com.example.web_store.repo.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService implements IGoodService {
    @Autowired
    private GoodRepository goodRepository;

    @Override
    public Good getGoodById(Integer id) {
        return goodRepository.findGoodById(id);
    }

    @Override
    public Good save(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public void deleteById(Integer id) {
        goodRepository.deleteById(id);
    }

    @Override
    public Good createGood(CreateGood createGood) {
        Good good = new Good();
        good.setName(createGood.getName());
        good.setPrice(createGood.getPrice());
        return goodRepository.save(good);
    }

    @Override
    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }
}
