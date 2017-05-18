package com.wap.repositories;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class UserRepository extends BaseRepository {

    public UserRepository(MongoClient mongoClient) {
        super(mongoClient);

    }

    public boolean validateUser(String name, String password) {
        MongoCollection<Document> collection = database.getCollection("user");
        Document name1 = collection.find(eq("name", name)).first();
        System.out.println("----");
        System.out.println(name1);
        return false;
    }
}
