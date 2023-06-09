package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.docment.PlayerInfo;

public interface PlayerInfoRepository extends MongoRepository<PlayerInfo, Integer> {

}
