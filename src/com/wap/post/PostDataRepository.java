package com.wap.post;

import com.wap.common.BaseRepository;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.FindOptions;

import java.util.List;

public class PostDataRepository extends BaseRepository {
    public PostDataRepository(Datastore datastore) {
        super(datastore);
    }

    public List<PostData> getPostData() {
        return datastore.createQuery(PostData.class).order("-_id").asList(new FindOptions().limit(25));
    }

    public long getlength() {
        return datastore.getCount(PostData.class);
    }

    public List<PostData> getMorePostData(int now, int more) {
        return datastore.createQuery(PostData.class).order("-_id").asList(new FindOptions().skip(now).limit(more));
    }

    public List<PostData> getAllPostData() {
        return datastore.createQuery(PostData.class).order("-_id").asList(new FindOptions());
    }

    public PostData getPost(String Id) {
        return datastore.get(PostData.class, new ObjectId(Id));
    }

    public void save(PostData post) {
        datastore.save(post);
    }

    public void delete(PostData post) {
        datastore.delete(post);
    }
}
