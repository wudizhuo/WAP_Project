package com.wap.post;

import org.mongodb.morphia.annotations.Entity;

/**
 * Created by hongleyou on 2017/5/18.
 */

public class Comment {
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
