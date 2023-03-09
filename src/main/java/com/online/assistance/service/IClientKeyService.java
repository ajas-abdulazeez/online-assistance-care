package com.online.assistance.service;

public interface IClientKeyService {

    String getClientSecretKey(String appId);

    String generateNewSecret();
}
