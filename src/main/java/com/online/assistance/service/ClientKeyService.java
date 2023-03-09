package com.online.assistance.service;

import com.online.assistance.entity.Client;
import com.online.assistance.repository.SecretKeyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientKeyService implements IClientKeyService{

    @Autowired
    private SecretKeyDao secretKeyDao;

    @Override
    public String getClientSecretKey(String appId) {
//        Client client = secretKeyDao.findByAppId(appId);
//        client.getSecretKey();
        return null;
    }

    @Override
    public String generateNewSecret() {
        return null;
    }
}
