package com.wap.post;

import com.wap.common.BaseRepository;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 * Created by hongleyou on 2017/5/18.
 */
public class PostDataRepository extends BaseRepository {
    public PostDataRepository(Datastore datastore) {
        super(datastore);
    }

    public Query<PostData>  getPostData() {
        return datastore.createQuery(PostData.class);
    }
}
