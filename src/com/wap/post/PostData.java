package com.wap.post;

import com.wap.commet.Comment;
import com.wap.common.BaseModel;
import lombok.Data;
import org.mongodb.morphia.annotations.Entity;

import java.util.List;

/**
 * Created by hongleyou on 2017/5/18.
 */

@Entity("post_data")
@Data
public class PostData extends BaseModel{
    private String _id;
    private String name;
    private String title;
    private String content;
    private List<String> images;
    private List<Comment> comments;
    private Location location;
    private int like;

    public PostData() {
    }

    public PostData(String _id, String name, String title, String content, List<String> images, List<Comment> comments, Location location, int like) {
        this._id = _id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.images = images;
        this.comments = comments;
        this.location = location;
        this.like = like;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }


    public String getContent() {
        return content;
    }

    public List<String> getImages() {
        return images;
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

    public void setLike(int like) {
        this.like = like;
    }
}
