package com.wap.post;

import com.wap.common.BaseRepository;
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
}
