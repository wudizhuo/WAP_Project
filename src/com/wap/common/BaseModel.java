package com.wap.common;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public abstract class BaseModel {
    @Id
    private ObjectId id;
}
