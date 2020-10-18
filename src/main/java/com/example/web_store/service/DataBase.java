package com.example.web_store.service;

import com.example.web_store.CustomException;

import java.util.List;

public interface DataBase<T> {

    public List<T> getContent();

    public void setContent(List<T> dbContent);
    public T createObject(T t) throws CustomException;
}
