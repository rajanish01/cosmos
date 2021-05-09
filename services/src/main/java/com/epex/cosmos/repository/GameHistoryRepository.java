package com.epex.cosmos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameHistoryRepository extends MongoRepository<GameHistory, String> {
}
