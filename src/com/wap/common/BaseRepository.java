package com.wap.common;

import org.mongodb.morphia.Datastore;

public class BaseRepository {

    public final Datastore datastore;

    public BaseRepository(Datastore datastore) {
        this.datastore = datastore;
    }
}
