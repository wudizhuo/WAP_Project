package com.wap.post;

import com.wap.common.BaseModel;

import java.util.List;

/**
 * Created by hongleyou on 2017/5/18.
 */
public class PostData extends BaseModel{
    private String name;
    private String content;
    private String image;
    private List<Comment> comments;
    private Location location;
    private int like;

    public PostData(String name, String content, String image, List<Comment> comments, Location location, int like) {
        this.name = name;
        this.content = content;
        this.image = image;
        this.comments = comments;
        this.location = location;
        this.like = like;
    }
}
