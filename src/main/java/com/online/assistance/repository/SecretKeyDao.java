package com.online.assistance.repository;

import com.online.assistance.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretKeyDao extends CrudRepository<Client,String> {

    //findclientdatabyid
}
