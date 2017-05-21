package com.wap.commet;

import com.wap.common.BaseModel;
import org.mongodb.morphia.annotations.Entity;

public class Comment extends BaseModel {
    private String name;
    private String comment;

    public Comment() {
    }

    public Comment(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }
}
