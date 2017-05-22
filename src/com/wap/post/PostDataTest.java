package com.wap.post;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.List;

/**
 * Created by hongleyou on 2017/5/18.
 */
public class PostDataTest {
    public static void main(String[] args) {
        MongoClient mongo = new MongoClient();

        final Morphia morphia = new Morphia();
        morphia.mapPackage("com.wap");
        final Datastore datastore = morphia.createDatastore(mongo, "wap");
        datastore.ensureIndexes();

        String id = "5920ecc25065e62d6f423554";
        ObjectId objectId = new ObjectId(id);
        List<PostData> posts = new PostDataRepository(datastore).getPostData();
        for (PostData postData : posts)
            System.out.println(postData.getImages() == null ? "null" : postData.getImages().size());
        //List<PostData> objs = postData.asList();
//        System.out.println("----" + post.toString());
    }
}
