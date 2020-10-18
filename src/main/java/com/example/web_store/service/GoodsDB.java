package com.example.web_store.service;

import com.example.web_store.model.Good;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsDB implements DataBase<Good> {
    private List<Good> createdGoods = new ArrayList<>();

    @Override
    public List<Good> getContent() {
        return createdGoods;
    }

    @Override
    public void setContent(List<Good> dbContent) {
        this.createdGoods = dbContent;
    }

    @Override
    public Good createObject(Good good) {
        for (Good g : createdGoods) {
            if (g.getName().equals(good.getName())) {
                good.setId(g.getId());
                break;
            }
        }
        if (good.getId() == null)
            good.setId(createdGoods.size() + 1);
        createdGoods.add(good);
        return good;
    }

    public Integer getSize() {
        return createdGoods.size();
    }
}
