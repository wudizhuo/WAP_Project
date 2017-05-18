package com.wap.login;

import com.wap.common.BaseRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.List;

public class UserRepository extends BaseRepository {

    public UserRepository(Datastore datastore) {
        super(datastore);
    }

    public boolean validateUser(String name, String password) {
        final Query<User> query = datastore.createQuery(User.class);
        final List<User> employees = query.asList();
        System.out.println("---------");
        System.out.println(employees.toString());
        return false;
    }
}
