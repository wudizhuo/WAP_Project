package com.wap.post;

import com.wap.common.BaseRepository;
import com.wap.user.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.FindOptions;
import org.mongodb.morphia.query.Query;

import java.util.List;

/**
 * Created by hongleyou on 2017/5/18.
 */
public class PostDataRepository extends BaseRepository {
    public PostDataRepository(Datastore datastore) {
        super(datastore);
    }

    public List<PostData> getPostData() {
        return datastore.createQuery(PostData.class).order("-_id").asList(new FindOptions().limit(25));
    }

    public PostData getPost(String Id) {
        return datastore.get(PostData.class, new ObjectId(Id));
    }

    public void save(PostData post) {
        datastore.save(post);
    }
}
