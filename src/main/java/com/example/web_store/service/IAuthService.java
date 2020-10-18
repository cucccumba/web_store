package com.example.web_store.service;

import com.example.web_store.CustomException;
import com.example.web_store.model.LogData;
import com.example.web_store.model.User;

public interface IAuthService {
    User authUser(LogData logData) throws CustomException;
    User createUser(LogData logData) throws CustomException;
}
