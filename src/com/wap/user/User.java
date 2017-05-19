package com.wap.user;

import com.wap.common.BaseModel;
import lombok.Data;
import org.mongodb.morphia.annotations.Entity;

@Entity
@Data
public class User extends BaseModel {
    private String name;
    private String password;
    private String gender;
    private String state;
    private String city;
    private String street;
    private String zip;
    private String birthyear;
    private String email;

    public User() {
    }

}