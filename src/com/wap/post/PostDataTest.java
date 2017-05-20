package com.wap.post;

import com.mongodb.MongoClient;
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

        List<PostData> postData = new PostDataRepository(datastore).getPostData();
        //List<PostData> objs = postData.asList();
        System.out.println("----" + postData.toString());
    }
}
