package com.wap.login;

import com.wap.common.BaseModel;
import org.mongodb.morphia.annotations.Entity;

@Entity
public class User extends BaseModel {
    public String name;
    public String password;

    public User() {
    }
}