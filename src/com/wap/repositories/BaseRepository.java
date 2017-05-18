package com.wap.repositories;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class BaseRepository {

    public final MongoDatabase database;

    public BaseRepository(MongoClient mongoClient) {
        this.database = mongoClient.getDatabase("wap");
    }
}
