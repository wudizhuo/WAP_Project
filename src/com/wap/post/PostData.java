package com.wap.post;

import com.wap.common.BaseModel;
import lombok.Data;
import lombok.Getter;
import org.mongodb.morphia.annotations.Entity;

import java.util.List;

/**
 * Created by hongleyou on 2017/5/18.
 */

@Entity("post_data")
public class PostData extends BaseModel{
    private String name;
    private String content;
    private String image;
    private List<Comment> comments;
    private Location location;
    private int like;

    public PostData() {
    }

    public PostData(String name, String content, String image, List<Comment> comments, Location location, int like) {
        this.name = name;
        this.content = content;
        this.image = image;
        this.comments = comments;
        this.location = location;
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Location getLocation() {
        return location;
    }

    public int getLike() {
        return like;
    }
}
