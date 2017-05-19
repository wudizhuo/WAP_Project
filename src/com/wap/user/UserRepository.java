package com.wap.user;

import com.wap.common.BaseRepository;
import org.mongodb.morphia.Datastore;

public class UserRepository extends BaseRepository {

    public UserRepository(Datastore datastore) {
        super(datastore);
    }

    public User get(String name, String password) {
        return datastore.createQuery(User.class).field("name").equal(name).field("password").equal(password).get();
    }

    public void save(User user) {
        datastore.save(user);
    }
}
